package com.example.coral.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Spinner;
import java.util.Random;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText playerNameInput;
    EditText numberOfCoins;
    TextView resultView;
    Button play;
    String guess;
    TextView winView;
    TextView headNumView;
    TextView tailNumView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // pass data field of interface
        playerNameInput = (EditText)findViewById(R.id.nameInput);
        numberOfCoins = (EditText)findViewById(R.id.numberOfCoinsInput);
        resultView = (TextView) findViewById(R.id.resultView);
        winView = (TextView)findViewById(R.id.win);
        headNumView = (TextView)findViewById(R.id.headNumView) ;
        tailNumView = (TextView)findViewById(R.id.tailNumView);

        // initial spinner data
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray((R.array.names)));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(myAdapter);
        guess = spin.getSelectedItem().toString();

        play = (Button)findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // initial variables of result
                int numberOfHead = 0;
                int numberOfTail = 0;
                String  win = "";
                // coins number process
                String b = numberOfCoins.getText().toString();
                ArrayList<Integer> d = generateData(Integer.parseInt(b));
                // set number of coin field to 2 by default
                numberOfCoins.setText("2");
                // calculate the number of head and tail
                for(int i=0; i<d.size();i++){
                    System.out.println(i + ":" + d.get(i));
                    if(d.get(i) == 0){
                        numberOfHead++;
                    }else if(d.get(i) == 1){
                        numberOfTail++;
                    }
                }

                // get the result (head or tail win)
                if(numberOfHead>numberOfTail){
                    win = "HEAD";
                    resultView.setText("Head");
                }else if(numberOfHead<numberOfTail){
                    win = "TAIL";
                    resultView.setText("TAIL");
                }else{
                    win = "TIE";
                    resultView.setText("IT IS TIE");
                }

                headNumView.setText(numberOfHead);
                tailNumView.setText(numberOfTail);
                // compare player result and get the winner or loser
                if(win == guess){
                    winView.setText("Winner");
                }else{
                    winView.setText("Loser");
                }
            }
        });;
    }

    public ArrayList generateData(int numOfCoin){
        ArrayList<Integer> coinDataList = new ArrayList<Integer>();
        for(int i=0;i<numOfCoin;i++){
            int random = new Random().nextInt(2);
            System.out.println("random "+ i+":" + random);
            coinDataList.add(random);
        }
        return coinDataList;
    }
}

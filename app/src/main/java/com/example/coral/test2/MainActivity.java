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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerNameInput = (EditText)findViewById(R.id.nameInput);
        numberOfCoins = (EditText)findViewById(R.id.numberOfCoinsInput);
        resultView = (TextView) findViewById(R.id.resultView);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray((R.array.names)));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(myAdapter);


        play = (Button)findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int numberOfHead = 0;
                int numberOfTail = 0;
                String b = numberOfCoins.getText().toString();
                System.out.println(b);
                ArrayList<Integer> d = generateData(Integer.parseInt(b));
                for(int i=0; i<d.size();i++){
                    System.out.println(i + ":" + d.get(i));
                    if(d.get(i) == 0){
                        numberOfHead++;
                    }else if(d.get(i) == 1){
                        numberOfTail++;
                    }
                }

                if(numberOfHead>numberOfTail){
                    System.out.println("HEAD win");
                }else if(numberOfHead<numberOfTail){
                    System.out.println("TAIL win");
                }else{
                    System.out.println("It is TIE");
                }

                System.out.println("Head: " + numberOfHead);
                System.out.println("Tail: " + numberOfTail);


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

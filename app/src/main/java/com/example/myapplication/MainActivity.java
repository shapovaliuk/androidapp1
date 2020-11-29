package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText wpr;
    Button b;
    TextView odp;
    Random random = new Random();
    int rInt;
    int wprInt;
    int pr = 7;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wpr = findViewById(R.id.liczba_wpr);
        b = findViewById(R.id.przycisk);
        odp = findViewById(R.id.odp);
        rInt = random.nextInt(100)+1;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pr==0){
                    odp.setText("Przegrałeś:(");
                    wpr.setEnabled(false);
                    b.setEnabled(false);
                }
                wprInt=Integer.parseInt(wpr.getText().toString());
                if(rInt>wprInt){
                   odp.setText("Liczba " + wprInt + " mniejsze od wylosowanej");
                   pr--;
                   Toast.makeText(getApplicationContext(),"Pozostało " + pr + " prób.",Toast.LENGTH_LONG).show();
                }
                else if(rInt<wprInt){
                   odp.setText("Liczba " + wprInt + " większe od wylosowanej");
                   pr--;
                   Toast.makeText(getApplicationContext(),"Pozostało " + pr + " prób.",Toast.LENGTH_LONG).show();
                }
                else if(rInt==wprInt){
                   odp.setText("Brawo! Zgadnełeś wylosowaną liczbę!");
                   count = 7 - pr;
                   Toast.makeText(getApplicationContext(),"Ilość podejść: " + count,Toast.LENGTH_LONG).show();
                   wpr.setEnabled(false);
                   b.setEnabled(false);
                }
            }
        });




    }
}
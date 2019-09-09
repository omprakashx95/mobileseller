package com.example.omprakash.apk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class Retailer extends AppCompatActivity {

   LinearLayout b1,b2,b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer);

        LinearLayout b2 = findViewById(R.id.button2);
        b2.setEnabled(false);
        LinearLayout b3 = findViewById(R.id.button3);
        b3.setEnabled(false);
        LinearLayout b1 = findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Retailer.this, Home.class);
                startActivity(i);
            }
        });
    }
}

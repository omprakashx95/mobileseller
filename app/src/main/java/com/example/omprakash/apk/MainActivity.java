package com.example.omprakash.apk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button b1;
EditText e;

DBAPI ob=new DBAPI();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=findViewById(R.id.button1);
        e=findViewById(R.id.edit1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i=new Intent(MainActivity.this,dashboard.class);
                //startActivity(i);
                //
                // finish();
                ob.otp_gen(MainActivity.this,e.getText().toString());
            }
        });
    }
}

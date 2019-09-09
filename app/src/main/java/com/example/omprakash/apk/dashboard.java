package com.example.omprakash.apk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {
Button b1,b2;
EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Button b1=findViewById(R.id.button1);
        Button b2=findViewById(R.id.button2);
        edit=findViewById(R.id.edit1);
        Intent intent = getIntent();
        final String message = intent.getStringExtra("otp");
        Log.v("otp",message);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String number=edit.getText().toString();

                if(number.equals(message)){
                Intent i=new Intent(dashboard.this,Retailer.class);
                startActivity(i);
                finish();}
                else{
                    Toast.makeText(dashboard.this, "wrong otp", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(dashboard.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

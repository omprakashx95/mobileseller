package com.example.omprakash.apk;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Color_Quantity extends AppCompatActivity {
    DatabaseHelper myDb;

    Button b1;
    int minteger = 0;
    int minteger1 = 0;
    int minteger2 = 0;
    int minteger3 = 0;
    TextView displayInteger, displayInteger2, displayInteger3, displayInteger4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color__quantity);
        myDb = new DatabaseHelper(this);

        getSupportActionBar().setTitle("Color And Quantity");
        b1 = findViewById(R.id.button1);
        Intent intent = getIntent();
        final String message = intent.getStringExtra("brand");
        final String message1 = intent.getStringExtra("category");
        final String message3 = intent.getStringExtra("model");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(message,
                        message1,
                        message3,displayInteger.getText().toString(), displayInteger2.getText().toString(),
                        displayInteger3.getText().toString(), displayInteger4.getText().toString());
                if (isInserted == true)
                    Toast.makeText(Color_Quantity.this, "Data 1 Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Color_Quantity.this, "Data 1 not Inserted", Toast.LENGTH_LONG).show();

                Intent i = new Intent(Color_Quantity.this, Order.class);

                startActivity(i);

            }
        });

    }


    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }

    public void decreaseInteger(View view) {
        if (minteger != 0) {
            minteger = minteger - 1;
            display(minteger);
        }

    }

    public void display(int number) {
        displayInteger = (TextView) findViewById(
                R.id.integer_number);
        displayInteger.setText("" + number);
    }

    public void increaseInteger1(View view) {
        minteger1 = minteger1 + 1;
        display1(minteger1);

    }

    public void decreaseInteger1(View view) {
        if (minteger1 != 0) {
            minteger1 = minteger1 - 1;
            display1(minteger1);
        }

    }

    private void display1(int number) {
        displayInteger2 = (TextView) findViewById(
                R.id.integer_number2);
        displayInteger2.setText("" + number);
    }

    public void increaseInteger2(View view) {
        minteger2 = minteger2 + 1;
        display2(minteger2);

    }

    public void decreaseInteger2(View view) {
        if (minteger2 != 0) {
            minteger2 = minteger2 - 1;
            display2(minteger2);
        }

    }

    private void display2(int number) {
        displayInteger3 = (TextView) findViewById(
                R.id.integer_number3);
        displayInteger3.setText("" + number);
    }

    public void increaseInteger3(View view) {
        minteger3 = minteger3 + 1;
        display3(minteger3);

    }

    public void decreaseInteger3(View view) {
        if (minteger3 != 0) {
            minteger3 = minteger3 - 1;
            display3(minteger3);
        }

    }

    private void display3(int number) {
        displayInteger4 = (TextView) findViewById(
                R.id.integer_number4);
        displayInteger4.setText("" + number);
    }

}



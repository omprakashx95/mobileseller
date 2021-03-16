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
    int price = 250;
    int sum = 0, sum1 = 0, sum2 = 0, sum3 = 0;
    int total = 0;
    int minteger3 = 0;
    TextView mop, mop2, mop3, mop4;
    TextView tot;
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
                if((minteger==0)&&(minteger1==0)&&(minteger2==0)&&(minteger3==0)) {
                    Toast.makeText(Color_Quantity.this, "Please select some Quantity", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean isInserted = myDb.insertData(message,
                            message1,
                            message3, String.valueOf(minteger), String.valueOf(minteger1),
                            String.valueOf(minteger2), String.valueOf(minteger3), String.valueOf(sum), String.valueOf(sum1), String.valueOf(sum2), String.valueOf(sum3), String.valueOf(total));
                    if (isInserted == true)
                        Toast.makeText(Color_Quantity.this, "Data 1 Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Color_Quantity.this, "Data 1 not Inserted", Toast.LENGTH_LONG).show();

                    Intent i = new Intent(Color_Quantity.this, Order.class);

                    startActivity(i);
                }

            }
        });

        tot = findViewById(R.id.total);
        hideTotal(total);

    }


    public void increaseInteger(View view) {
        minteger = minteger + 1;
        sum = sum + price;
        total = sum + sum1 + sum2 + sum3;
        display(minteger, sum, total);

    }

    void hideTotal(int total) {
        if (total == 0)
            tot.setVisibility(View.GONE);
        else
            tot.setVisibility(View.VISIBLE);
    }

    public void decreaseInteger(View view) {
        if (minteger != 0) {
            minteger = minteger - 1;
            sum = sum - price;
            total = sum + sum1 + sum2 + sum3;

            display(minteger, sum, total);
        }

    }

    public void display(int number, int p, int t) {
        total = sum + sum1 + sum2 + sum3;
        displayInteger = (TextView) findViewById(
                R.id.counter);
        mop = findViewById(R.id.mop);

        tot.setText("" + t);
        displayInteger.setText("" + number);
        mop.setText("" + p);
        hideTotal(t);
    }

    public void increaseInteger1(View view) {
        minteger1 = minteger1 + 1;
        sum1 = sum1 + price;
        total = sum + sum1 + sum2 + sum3;

        display1(minteger1, sum1, total);

    }

    public void decreaseInteger1(View view) {
        if (minteger1 != 0) {
            minteger1 = minteger1 - 1;
            sum1 = sum1 - price;
            total = sum + sum1 + sum2 + sum3;

            display1(minteger1, sum1, total);
        }

    }

    private void display1(int number, int p, int t) {
        displayInteger2 = (TextView) findViewById(
                R.id.counter2);
        mop2 = findViewById(R.id.mop2);

        tot.setText("" + t);

        displayInteger2.setText("" + number);
        mop2.setText("" + p);


        hideTotal(t);
    }

    public void increaseInteger2(View view) {
        minteger2 = minteger2 + 1;
        sum2 = sum2 + price;
        total = sum + sum1 + sum2 + sum3;

        display2(minteger2, sum2, total);

    }

    public void decreaseInteger2(View view) {
        if (minteger2 != 0) {
            minteger2 = minteger2 - 1;
            sum2 = sum2 - price;
            total = sum + sum1 + sum2 + sum3;

            display2(minteger2, sum2, total);
        }

    }

    private void display2(int number, int p, int t) {
        displayInteger3 = (TextView) findViewById(
                R.id.counter3);
        mop3 = findViewById(R.id.mop3);

        tot.setText("" + t);

        displayInteger3.setText("" + number);
        mop3.setText("" + p);

        hideTotal(t);
    }

    public void increaseInteger3(View view) {
        minteger3 = minteger3 + 1;
        sum3 = sum3 + price;
        total = sum + sum1 + sum2 + sum3;

        display3(minteger3, sum3, total);

    }

    public void decreaseInteger3(View view) {
        if (minteger3 != 0) {
            minteger3 = minteger3 - 1;
            sum3 = sum3 - price;
            total = sum + sum1 + sum2 + sum3;

            display3(minteger3, sum3, total);
        }

    }

    private void display3(int number, int p, int t) {
        displayInteger4 = (TextView) findViewById(
                R.id.counter4);

        mop4 = findViewById(R.id.mop4);

        tot.setText("" + t);

        displayInteger4.setText("" + number);
        mop4.setText("" + p);

        hideTotal(t);
    }

}



package com.example.omprakash.apk;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.omprakash.apk.fragments.Brand1Fragment;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {
    DatabaseHelper myDb;
    List<CartModel> dataList;
    List<CartModel> dataList1;
    CartModel model;
    Button b1;


    ListView grid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        dataList = new ArrayList<>();
        b1 = findViewById(R.id.button1);
        grid = findViewById(R.id.grid);


        myDb = new DatabaseHelper(this);
        Cursor cursor = myDb.getAllData();


        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Noting Found", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {

                model = new CartModel();
                model.setId(cursor.getString(0));
                model.setName(cursor.getString(1));
                model.setSurname(cursor.getString(2));
                model.setMarks(cursor.getString(3));
                model.setColor1(cursor.getString(4));
                model.setColor2(cursor.getString(5));
                model.setColor3(cursor.getString(6));
                model.setColor4(cursor.getString(7));
                model.setMop1(cursor.getString(8));
                model.setMop2(cursor.getString(9));
                model.setMop3(cursor.getString(10));
                model.setMop4(cursor.getString(11));
                model.setTotal(cursor.getString(12));

                dataList.add(model);
            }
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalVar.isBrand = true;
                startActivity(new Intent(Order.this, Home.class));
                finishAffinity();
            }
        });

        final ListAdapter adapter = new ListAdapter(Order.this, dataList);
        grid.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        grid.invalidateViews();
        Log.e("dbLog", "Cart Data Size" + dataList.size());
    }

}

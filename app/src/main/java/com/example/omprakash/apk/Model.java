package com.example.omprakash.apk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.omprakash.apk.adapter.CategoryAdapter;
import com.example.omprakash.apk.adapter.MyModelAdapter;

public class Model extends AppCompatActivity {
    GridView grid;

    String[] web = {
            "Model 1", "Model 2",
            "Model 3", "Model 4", "Model 5",
            "Model 6", "Model 7",
            "Model 8", "Model 9",
            "Model 10", "Model 11", "Model 12", "Model 13",
            "Model 14", "Model 15"


    };

    String[] mop = {
            "MOP1","MOP2",
            "MOP3","MOP4",
            "MOP5","MOP6","MOP7","MOP8","MOP9",
            "MOP10","MOP11","MOP12",
            "MOP13","MOP14","MOP15"


    };
    String[] mrp = {
            "MRP1","MRP2",
            "MRP3","MRP4","MRP5","MRP6",
            "MRP7","MRP8","MRP9","MRP-10",
            "MRP11","MRP12","MRP13","MRP14",
            "MRP15"


    };
    String[] offer = {
            "Offer1","Offer2",
            "Offer3",
            "Offer4",
            "Offer5","Offer6","Offer7","Offer8","Offer9","Offer10",
            "Offer11","Offer12","Offer13","Offer14","Offer15"



    };

    Integer[] imgid = {
            R.drawable.profile, R.drawable.profile,
            R.drawable.profile, R.drawable.profile,
            R.drawable.profile, R.drawable.profile, R.drawable.profile,
            R.drawable.profile, R.drawable.profile,
            R.drawable.profile, R.drawable.profile, R.drawable.profile,
            R.drawable.profile, R.drawable.profile,
            R.drawable.profile,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        getSupportActionBar().setTitle("Models");
        final MyModelAdapter adapter = new MyModelAdapter(Model.this, web,imgid, mop, mrp, offer);
        grid= findViewById(R.id.grid);
        grid.setAdapter(adapter);
        Intent intent = getIntent();
        final String message = intent.getStringExtra("key");
        final String message1 = intent.getStringExtra("key1");

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String value= web[position];

                Intent i = new Intent(Model.this, Color_Quantity.class);
                i.putExtra("brand",message);
                i.putExtra("category",message1);
                i.putExtra("model",value);
                startActivity(i);
                Toast.makeText(Model.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });


    }

}
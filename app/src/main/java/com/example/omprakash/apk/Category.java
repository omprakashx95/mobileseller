
package com.example.omprakash.apk;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.omprakash.apk.adapter.CategoryAdapter;
import com.example.omprakash.apk.adapter.ImageAdapter;
import com.example.omprakash.apk.adapter.MyListAdapter;

public class Category extends AppCompatActivity {
    GridView grid;
    String[] web = {
            "Camera",
            "EarPhone",
            "Mobile",
            "Battery",
            "Usb",
            "Charger",
            "HeadPhone",
            "CardReader",
            "UsbCable",
            "Tablet",
            "Monitor",
            "Pendrive",
            "Powerbank",
            "Adapter",
            "BackCover"
    } ;
    int[] imageId = {
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,R.drawable.icon,R.drawable.icon,
            R.drawable.icon,R.drawable.icon,
            R.drawable.icon,R.drawable.icon,R.drawable.icon,
            R.drawable.icon,R.drawable.icon,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().setTitle("Categories");

        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPage);
        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager, true);
        Intent intent = getIntent();
        final String message = intent.getStringExtra("TextBox");

        final CategoryAdapter adapter=new CategoryAdapter(Category.this, web, imageId);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String value=web[position];

                Intent i = new Intent(Category.this, Model.class);
                i.putExtra("key",message);
                i.putExtra("key2",value);
                startActivity(i);
                Toast.makeText(Category.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchViewAndroidActionBar = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchViewAndroidActionBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchViewAndroidActionBar.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}
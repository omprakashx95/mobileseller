package com.example.omprakash.apk.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omprakash.apk.Category;
import com.example.omprakash.apk.R;
import com.example.omprakash.apk.adapter.CustomGrid;
import com.example.omprakash.apk.adapter.ImageAdapter;

public class Brand1Fragment extends Fragment {
    GridView gridView;
    TextView textView;
    String[] listItem;
    String[] brand = {
            "Sony",
            "Vivo",
            "Oppo",
            "Redmi",
            "Realme",
            "Samsung",
            "Nokia",
            "Lava",
            "Lenovo",
            "GooglePixel",
            "OnePlus",
            "Apple",
            "karbon",
            "CoolPad",
            "Jio"

    } ;
    int[] imageId = {
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,
            R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,


    };


    public Brand1Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_brand1, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager mViewPager = view.findViewById(R.id.viewPage);
        final ImageAdapter adapterView = new ImageAdapter(getContext());
        mViewPager.setAdapter(adapterView);

        TabLayout tabLayout =view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager, true);

        gridView = view.findViewById(R.id.grid);
        textView = view.findViewById(R.id.textView);
        listItem = getResources().getStringArray(R.array.array_technology);
        final CustomGrid adapter = new CustomGrid(getActivity(), brand, imageId);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String value= (String) adapter.getItem(position);
            Log.v(value,"run");
                Intent i= new Intent(getActivity(),Category.class);
                i.putExtra ( "TextBox", value );
                startActivity(i);
                Toast.makeText(getActivity(), "You Clicked at " +brand[+ position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}

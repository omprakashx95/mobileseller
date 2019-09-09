 package com.example.omprakash.apk.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.omprakash.apk.R;

public class MyModelAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] web;
    private final String[] offer;
    private final String[] mop;
    private final String[] mrp;
    private final Integer[] Imageid;

    public MyModelAdapter(Context c,String[] web,Integer[] Imageid,String[] mop,String[] mrp,String[] offer ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
        this.mrp=mrp;
        this.offer=offer;
        this.mop=mop;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int c = position ;
        if (convertView == null) {
            grid = inflater.inflate(R.layout.listmodel, null);

           } else {
            grid = (View) convertView;
        }
        TextView textView = (TextView) grid.findViewById(R.id.grid_text);
        TextView textView1 = (TextView) grid.findViewById(R.id.grid_text1);
        TextView textView2 = (TextView) grid.findViewById(R.id.grid_text2);
        TextView textView3 = (TextView) grid.findViewById(R.id.grid_text3);
        ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);

        textView.setText(web[position]);
        textView1.setText(mop[position]);
        textView2.setText(mrp[position]);
        textView3.setText(offer[position]);
        imageView.setImageResource(Imageid[position]);



        return grid;
    }

}
package com.example.omprakash.apk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private Context mContext;
    DatabaseHelper myDb;
    int price = 250;

    //private final String[] web;
    //private final int[] Imageid;
    private final List<CartModel> dataList;
    //private final List<CartModel> dataList1;

    public ListAdapter(Context c, List<CartModel> dataList) {
        mContext = c;
        this.dataList = dataList;
        myDb = new DatabaseHelper(mContext);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid, null);

        } else {
            grid = (View) convertView;
        }

        final CartModel m = dataList.get(position);
        //  CartModel n = dataList1.get(position);

        final TextView textView1 = (TextView) grid.findViewById(R.id.text1);
        final TextView textView2 = (TextView) grid.findViewById(R.id.text2);
        final TextView textView3 = (TextView) grid.findViewById(R.id.text3);
        Button button1 = grid.findViewById(R.id.plus);
        Button button2 = grid.findViewById(R.id.plus2);
        Button button3 = grid.findViewById(R.id.plus3);
        Button button4 = grid.findViewById(R.id.plus4);

        Button button5 = grid.findViewById(R.id.minus);
        Button button6 = grid.findViewById(R.id.minus2);
        Button button7 = grid.findViewById(R.id.minus3);
        Button button8 = grid.findViewById(R.id.minus4);

        final TextView c1 = grid.findViewById(R.id.counter);
        final TextView c2 = grid.findViewById(R.id.counter2);
        final TextView c3 = grid.findViewById(R.id.counter3);
        final TextView c4 = grid.findViewById(R.id.counter4);
        final TextView mop1 = grid.findViewById(R.id.mop1);
        final TextView mop2 = grid.findViewById(R.id.mop2);
        final TextView mop3 = grid.findViewById(R.id.mop3);
        final TextView mop4 = grid.findViewById(R.id.mop4);
        final TextView total = grid.findViewById(R.id.total);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c1Value = Integer.parseInt(c1.getText().toString());
                int c2Value = Integer.parseInt(c2.getText().toString());
                int c3Value = Integer.parseInt(c3.getText().toString());
                int c4Value = Integer.parseInt(c4.getText().toString());
                int tot = Integer.parseInt(total.getText().toString());
                int mp = Integer.parseInt(mop1.getText().toString());

                c1Value++;
                mp = mp + price;
                tot = tot + price;
                c1.setText(String.valueOf(c1Value));
                mop1.setText(String.valueOf(mp));
                total.setText(String.valueOf(tot));
                String i = m.getId();
                dbUpdate(i, textView1, textView2, textView3,c1Value,c2Value, c3Value,c4Value);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int c1Value = Integer.parseInt(c1.getText().toString());
                int c2Value = Integer.parseInt(c2.getText().toString());
                int c3Value = Integer.parseInt(c3.getText().toString());
                int c4Value = Integer.parseInt(c4.getText().toString());
                int tot = Integer.parseInt(total.getText().toString());
                int mp = Integer.parseInt(mop2.getText().toString());

                c2Value++;
                mp = mp + price;
                tot = tot + price;
                mop2.setText(String.valueOf(mp));
                c2.setText(String.valueOf(c2Value));
                total.setText(String.valueOf(tot));

                String i = m.getId();
                dbUpdate(i, textView1, textView2, textView3,c1Value,c2Value, c3Value,c4Value);


            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c1Value = Integer.parseInt(c1.getText().toString());
                int c2Value = Integer.parseInt(c2.getText().toString());
                int c3Value = Integer.parseInt(c3.getText().toString());
                int c4Value = Integer.parseInt(c4.getText().toString());
                int tot = Integer.parseInt(total.getText().toString());
                int mp = Integer.parseInt(mop3.getText().toString());

                c3Value++;
                mp = mp + price;
                tot = tot + price;
                mop3.setText(String.valueOf(mp));
                c3.setText(String.valueOf(c3Value));
                total.setText(String.valueOf(tot));
                String i = m.getId();
                dbUpdate(i, textView1, textView2, textView3,c1Value,c2Value, c3Value,c4Value);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c1Value = Integer.parseInt(c1.getText().toString());
                int c2Value = Integer.parseInt(c2.getText().toString());
                int c3Value = Integer.parseInt(c3.getText().toString());
                int c4Value = Integer.parseInt(c4.getText().toString());
                int tot = Integer.parseInt(total.getText().toString());
                int mp = Integer.parseInt(mop4.getText().toString());

                c4Value++;
                mp = mp + price;
                tot = tot + price;
                mop4.setText(String.valueOf(mp));
                c4.setText(String.valueOf(c4Value));
                total.setText(String.valueOf(tot));
                String i = m.getId();
                dbUpdate(i, textView1, textView2, textView3,c1Value,c2Value, c3Value,c4Value);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c1Value = Integer.parseInt(c1.getText().toString());
                int c2Value = Integer.parseInt(c2.getText().toString());
                int c3Value = Integer.parseInt(c3.getText().toString());
                int c4Value = Integer.parseInt(c4.getText().toString());
                int tot = Integer.parseInt(total.getText().toString());
                int mp = Integer.parseInt(mop1.getText().toString());

                if (c1Value != 0) {
                    c1Value--;
                    mp=mp-price;
                    tot = tot - price;

                    mop1.setText(String.valueOf(mp));
                    c1.setText(String.valueOf(c1Value));
                    total.setText(String.valueOf(tot));
                }
                String i = m.getId();
                if((c1Value == 0)&&(c2Value==0)&&(c3Value==0)&&(c4Value==0)){

                    myDb.deleteData(i);
                }


                dbUpdate(i, textView1, textView2, textView3,c1Value,c2Value, c3Value,c4Value);

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c1Value = Integer.parseInt(c1.getText().toString());
                int c2Value = Integer.parseInt(c2.getText().toString());
                int c3Value = Integer.parseInt(c3.getText().toString());
                int c4Value = Integer.parseInt(c4.getText().toString());
                int tot = Integer.parseInt(total.getText().toString());
                int mp = Integer.parseInt(mop2.getText().toString());

                if (c2Value != 0) {
                    c2Value--;
                    mp=mp-price;
                    tot = tot - price;
                    mop2.setText(String.valueOf(mp));
                    c2.setText(String.valueOf(c2Value));
                    total.setText(String.valueOf(tot));
                }
                String i = m.getId();
                dbUpdate(i, textView1, textView2, textView3,c1Value,c2Value, c3Value,c4Value);
                if((c1Value == 0)&&(c2Value==0)&&(c3Value==0)&&(c4Value==0)){

                    myDb.deleteData(i);
                }


            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c1Value = Integer.parseInt(c1.getText().toString());
                int c2Value = Integer.parseInt(c2.getText().toString());
                int c3Value = Integer.parseInt(c3.getText().toString());
                int mp = Integer.parseInt(mop3.getText().toString());
                int c4Value = Integer.parseInt(c4.getText().toString());
                int tot = Integer.parseInt(total.getText().toString());
                if (c3Value != 0) {
                    c3Value--;
                    tot = tot - price;
                    mp=mp-price;
                    mop3.setText(String.valueOf(mp));
                    c3.setText(String.valueOf(c3Value));
                    total.setText(String.valueOf(tot));

                }

                String i = m.getId();
                dbUpdate(i, textView1, textView2, textView3,c1Value,c2Value, c3Value,c4Value);
                if((c1Value == 0)&&(c2Value==0)&&(c3Value==0)&&(c4Value==0)){

                    myDb.deleteData(i);
                }

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c1Value = Integer.parseInt(c1.getText().toString());
                int c2Value = Integer.parseInt(c2.getText().toString());
                int c3Value = Integer.parseInt(c3.getText().toString());
                int c4Value = Integer.parseInt(c4.getText().toString());
                int mp = Integer.parseInt(mop4.getText().toString());
                int tot = Integer.parseInt(total.getText().toString());
                if (c4Value != 0) {
                    c4Value--;
                    tot = tot - price;
                    mp=mp-price;
                    mop4.setText(String.valueOf(mp));
                    c4.setText(String.valueOf(c4Value));
                    total.setText(String.valueOf(tot));

                }
                String i = m.getId();
                dbUpdate(i, textView1, textView2, textView3,c1Value,c2Value, c3Value,c4Value);

                if((c1Value == 0)&&(c2Value==0)&&(c3Value==0)&&(c4Value==0)){

                    myDb.deleteData(i);
                }

            }
        });

        textView1.setText(m.getName());
        textView2.setText(m.getSurname());
        textView3.setText(m.getMarks());
        c1.setText(m.getColor1());
        c2.setText(m.getColor2());
        c3.setText(m.getColor3());
        c4.setText(m.getColor4());
        mop1.setText(m.getMop1());
        mop2.setText(m.getMop2());
        mop3.setText(m.getMop3());
        mop4.setText(m.getMop4());
        total.setText(m.getTotal());
        return grid;
    }

    private void dbUpdate(String id, TextView name, TextView surName, TextView marks, int c1,
                          int c2, int c3, int c4) {
        myDb.updateData(id, name.getText().toString(), surName.getText().toString(),
                marks.getText().toString(), String.valueOf(c1), String.valueOf(c2),
                String.valueOf(c3), String.valueOf(c4));
    }
}
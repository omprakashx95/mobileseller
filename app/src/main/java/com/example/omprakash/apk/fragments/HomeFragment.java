package com.example.omprakash.apk.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.omprakash.apk.adapter.MyListAdapter;
import com.example.omprakash.apk.R;

public class HomeFragment extends Fragment {
    ListView list;

    String[] maintitle ={
            "Title 1","Title 2",
            "Title 3","Title 4",
            "Title 5",
    };

    String[] subtitle ={
            "Sub Title 1","Sub Title 2",
            "Sub Title 3","Sub Title 4",
            "Sub Title 5",
    };

    Integer[] imgid={
            R.drawable.offer1,R.drawable.offer2,
            R.drawable.offer1,R.drawable.offer2,
            R.drawable.offer1,
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container ,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MyListAdapter adapter=new MyListAdapter(getActivity(), maintitle, subtitle,imgid);
        list=view.findViewById(R.id.list);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    Toast.makeText(getActivity(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getActivity(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    Toast.makeText(getActivity(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    Toast.makeText(getActivity(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    Toast.makeText(getActivity(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

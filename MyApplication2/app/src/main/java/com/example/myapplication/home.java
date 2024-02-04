package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class home extends Fragment {
RecyclerView homerv;
    String[] title_names={"Nature","Rain","Colors"};
    int[] title_img={R.drawable.sampone,R.drawable.sampthree,R.drawable.samptwo};
    int[] title_logo={R.drawable.sampone,R.drawable.sampthree,R.drawable.samptwo};


    public home() {
        // Required empty public constructor
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home, container, false);
       homerv=(RecyclerView) view.findViewById(R.id.homerecycler);
       adaptor adaptor=new adaptor(title_logo,title_img,title_names);
       homerv.setLayoutManager(new LinearLayoutManager(getContext()));
       homerv.setAdapter(adaptor);

        return view;
    }
}
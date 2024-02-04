package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class search extends Fragment {
RecyclerView rv;
    int[] imgs={R.drawable.sampone,R.drawable.samptwo,R.drawable.sampthree,R.drawable.samptwo,R.drawable.samptwo,R.drawable.sampthree,R.drawable.samptwo,R.drawable.sampone,R.drawable.sampone,R.drawable.samptwo,R.drawable.sampthree,R.drawable.samptwo,R.drawable.samptwo,R.drawable.sampthree,R.drawable.samptwo,R.drawable.sampone,R.drawable.sampone,R.drawable.samptwo,R.drawable.sampthree,R.drawable.samptwo,R.drawable.samptwo,R.drawable.sampthree,R.drawable.samptwo,R.drawable.sampone,R.drawable.sampone,R.drawable.samptwo,R.drawable.sampthree,R.drawable.samptwo,R.drawable.samptwo,R.drawable.sampthree,R.drawable.samptwo,R.drawable.sampone};

    public search() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_search, container, false);

            rv=view.findViewById(R.id.recycler);
             Myadaptor myadaptor=new Myadaptor(imgs);
             rv.setLayoutManager(new StaggeredGridLayoutManager(3,LinearLayoutManager.VERTICAL));
             rv.setAdapter(myadaptor);
        return view;
    }
}
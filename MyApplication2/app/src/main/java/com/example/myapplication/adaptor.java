package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adaptor extends RecyclerView.Adapter<adaptor.MyViewHolder> {
    int[] logos;
    int[] images;
    String[] titles;

    public adaptor(int[] logo,int[] images,String[] title){
        this.logos=logo;
        this.images=images;
        this.titles=title;


    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.homepage,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
             holder.title.setText(titles[position]);
             holder.logo.setImageResource(logos[position]);
             holder.image.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
         private ImageView logo;
        private ImageView image;
        private TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            logo=(ImageView) itemView.findViewById(R.id.logo);
            image=(ImageView) itemView.findViewById(R.id.image);
            title=(TextView) itemView.findViewById(R.id.name);




        }
    }
}

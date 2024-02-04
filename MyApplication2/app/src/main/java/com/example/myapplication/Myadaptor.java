package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myadaptor extends RecyclerView.Adapter<Myadaptor.MyViewHolder> {

    int[] imgs;
    public Myadaptor(int[] imgs){
        this.imgs=imgs;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.searchpage,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
             holder.imageView.setImageResource(imgs[position]);
    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
            private ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.serchimages);
        }
    }


}

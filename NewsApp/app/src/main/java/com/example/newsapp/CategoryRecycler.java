package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryRecycler extends RecyclerView.Adapter<CategoryRecycler.MyHolder> {

ArrayList<CategoryModel> modelArrayList;
Context context;
private CategoryClick categoryClick;

    public CategoryRecycler(ArrayList<CategoryModel> modelArrayList, Context context, CategoryClick categoryClick) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.categoryClick = categoryClick;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categoryview,parent,false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context).load(modelArrayList.get(position).getImage()).into(holder.imageView);
        holder.category.setText(modelArrayList.get(position).getCategory());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryClick.click(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
    public interface CategoryClick{
        void click(int position);
    }


    class MyHolder extends RecyclerView.ViewHolder{
          ImageView imageView;
          TextView category;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.categoryimg);
            category=itemView.findViewById(R.id.categoryname);
        }
    }
}

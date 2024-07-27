package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsRecycler extends RecyclerView.Adapter<NewsRecycler.Myviewholder> {
    ArrayList<Articles> arrayList;
    Context context;

    public NewsRecycler(ArrayList<Articles> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.newsview,parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        Articles articles=arrayList.get(position);
            holder.title.setText(articles.getTitle());
            holder.content.setText(articles.getDescription());
        Glide.with(context).load(arrayList.get(position).getUrlToImage()).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailNews.class);
                intent.putExtra("title", articles.getTitle());
                intent.putExtra("content", articles.getContent());
                intent.putExtra("author", articles.getAuthor());
                intent.putExtra("image", articles.getUrlToImage());
                intent.putExtra("url", articles.getUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Myviewholder extends RecyclerView.ViewHolder{
      ImageView image;
      TextView title,content;
     public Myviewholder(@NonNull View itemView) {
         super(itemView);
         image=itemView.findViewById(R.id.image);
         title=itemView.findViewById(R.id.title);
         content=itemView.findViewById(R.id.description);
     }
 }
}

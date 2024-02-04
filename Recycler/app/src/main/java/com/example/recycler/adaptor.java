package com.example.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptor extends RecyclerView.Adapter<myViewholder> {
    ArrayList<Model> data;
    Context context;
    public adaptor(ArrayList<Model> data, Context context) {
        this.data = data;
        this.context = context;
    }



    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.dataview,parent,false);
        return new myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {
        final Model temp=data.get(position);
     holder.text.setText(data.get(position).name);
     holder.image.setImageResource(data.get(position).img);

     holder.image.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(context, MainActivity2.class);
             intent.putExtra("dataname",temp.getName());
             intent.putExtra("dataimg",temp.getImg());
             intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             context.startActivity(intent);
         }
     });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

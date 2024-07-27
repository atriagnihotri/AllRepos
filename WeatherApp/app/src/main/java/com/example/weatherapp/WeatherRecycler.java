package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WeatherRecycler extends RecyclerView.Adapter<WeatherRecycler.MyHolder> {
    ArrayList<WeatherModel> arrayList;
    Context context;

    public WeatherRecycler(ArrayList<WeatherModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecastdata, parent, false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tempe.setText(arrayList.get(position).getTemp());
        holder.timee.setText(arrayList.get(position).getTime());
        holder.cone.setText(arrayList.get(position).getCon());
        Picasso.get().load("http:" + arrayList.get(position).icon).into(holder.icone);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
       TextView cone,tempe,timee;
       ImageView icone;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            cone=itemView.findViewById(R.id.con);
            tempe=itemView.findViewById(R.id.temp);
            timee=itemView.findViewById(R.id.time);
            icone=itemView.findViewById(R.id.icon);}
    }
}

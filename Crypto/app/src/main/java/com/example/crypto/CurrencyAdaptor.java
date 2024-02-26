package com.example.crypto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CurrencyAdaptor extends RecyclerView.Adapter<CurrencyAdaptor.ViewHolder> {
    ArrayList<CurrencyModel> arrayList;
    Context context;

    public CurrencyAdaptor(ArrayList<CurrencyModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.symbols.setText(arrayList.get(position).getSymbol());
        holder.names.setText(arrayList.get(position).getName());
        holder.prices.setText(arrayList.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
TextView names,prices,symbols;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            names=itemView.findViewById(R.id.name);
            prices=itemView.findViewById(R.id.price);
            symbols=itemView.findViewById(R.id.symbol);
        }
    }
}

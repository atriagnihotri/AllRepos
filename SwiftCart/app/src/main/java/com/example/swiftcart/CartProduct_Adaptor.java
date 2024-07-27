package com.example.swiftcart;

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

public class CartProduct_Adaptor extends RecyclerView.Adapter<CartProduct_Adaptor.ViewHolder> {

    ArrayList<CartModel> cartModels;
    Context context;

    public CartProduct_Adaptor(ArrayList<CartModel> cartModels, Context context) {
        this.cartModels = cartModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.cart_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(cartModels.get(position).getName());
        holder.price.setText(cartModels.get(position).getPrice());
        Glide.with(context).load(cartModels.get(position).image).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
           ImageView image;
           TextView name,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.crimg);
            name=itemView.findViewById(R.id.crname);
            price=itemView.findViewById(R.id.crpice);
        }
    }
}

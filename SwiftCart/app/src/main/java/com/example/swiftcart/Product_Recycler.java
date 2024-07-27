package com.example.swiftcart;

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

public class Product_Recycler extends RecyclerView.Adapter<Product_Recycler.ViewHolder> {
    ArrayList<Products_Model> productsModels;
    Context context;

    public Product_Recycler(ArrayList<Products_Model> productsModels, Context context) {
        this.productsModels = productsModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.product_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Products_Model model=productsModels.get(position);
        String imgurl="http://192.168.43.249:8000"+productsModels.get(position).image;
          holder.name.setText(productsModels.get(position).name);
        holder.desc.setText(productsModels.get(position).description);
        holder.price.setText(productsModels.get(position).price);
        Glide.with(context).load(imgurl).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Product_View.class);
                intent.putExtra("prname",model.getName());
                intent.putExtra("prdesc",model.getDescription());
                intent.putExtra("primg",model.getImage());
                intent.putExtra("prprice",model.getPrice());
                intent.putExtra("prcat",model.getCategory());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productsModels.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
          ImageView imageView;
          TextView name,desc,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.primage);
            name=itemView.findViewById(R.id.prname);
            desc=itemView.findViewById(R.id.prdesc);
            price=itemView.findViewById(R.id.prprice);
        }
    }
}

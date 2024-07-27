package com.example.swiftcart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hishd.tinycart.model.Cart;
import com.hishd.tinycart.util.TinyCartHelper;

import java.util.ArrayList;

public class Product_View extends AppCompatActivity {
ImageView imageView;
TextView name,desc,price,category;
Button Order;
CartModel cartModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);
        imageView=findViewById(R.id.images);
        name=findViewById(R.id.names);
        desc=findViewById(R.id.descs);
        price=findViewById(R.id.prices);
        category=findViewById(R.id.category);
        Order=findViewById(R.id.order);
        Cart cart = TinyCartHelper.getCart();

        String imgurl="http://192.168.43.249:8000"+getIntent().getStringExtra("primg");
        Glide.with(getApplicationContext())
                .load(imgurl)
                .into(imageView);


        name.setText(getIntent().getStringExtra("prname"));
        desc.setText("DESCRIPTION : "+getIntent().getStringExtra("prdesc"));
        price.setText("₹ "+getIntent().getStringExtra("prprice"));
        category.setText("CATEGORY : "+getIntent().getStringExtra("prcat"));

        String name=getIntent().getStringExtra("prname");
        String price=getIntent().getStringExtra("prprice");

            cartModel=new CartModel(name,imgurl,price);
        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 cart.addItem(cartModel,1);
                Toast.makeText(Product_View.this, "Product Added ", Toast.LENGTH_SHORT).show();
                Order.setText("Added");
                Order.setBackgroundColor(getResources().getColor(R.color.grey));
            }
        });









    }
}
package com.example.swiftcart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hishd.tinycart.model.Cart;
import com.hishd.tinycart.model.Item;
import com.hishd.tinycart.util.TinyCartHelper;

import java.util.ArrayList;
import java.util.Map;

public class Orders extends Fragment {

    ArrayList<CartModel> cartModels;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_order, container, false);
        recyclerView=view.findViewById(R.id.cart_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cartModels=new ArrayList<>();
        Cart cart = TinyCartHelper.getCart();
        for (Map.Entry<Item,Integer> item:cart.getAllItemsWithQty().entrySet()){
            CartModel order_pass=(CartModel) item.getKey();
            int quantity= item.getValue();
            order_pass.setQuantity(quantity);
            cartModels.add(order_pass);
        }

//            cartModels.add(new CartModel("Zeb Thunder","/media/images/zeb_thunder.jpg","500"));
//        cartModels.add(new CartModel("Zeb Thunder","/media/images/zeb_thunder.jpg","500"));
//        cartModels.add(new CartModel("Zeb Thunder","/media/images/zeb_thunder.jpg","500"));
//        cartModels.add(new CartModel("Zeb Thunder","/media/images/zeb_thunder.jpg","500"));
           CartProduct_Adaptor cartProductAdaptor=new CartProduct_Adaptor(cartModels,getContext());
           recyclerView.setAdapter(cartProductAdaptor);






        return view;
    }
}
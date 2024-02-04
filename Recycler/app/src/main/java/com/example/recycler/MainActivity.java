package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adaptor adaptor=new adaptor(inserting(),getApplicationContext());
        recyclerView.setAdapter(adaptor);

    }
    public ArrayList<Model> inserting(){
        ArrayList<Model> holder=new ArrayList<>();
        Model model =new Model();
        model.setImg(R.drawable.image);
        model.setName("Atri");
        holder.add(model);

        Model model2 =new Model();
        model2.setImg(R.drawable.image);
        model2.setName("Atri2");
        holder.add(model2);
        Model model3 =new Model();
        model3.setImg(R.drawable.image);
        model3.setName("Atri3");
        holder.add(model3);
        Model model4 =new Model();
        model4.setImg(R.drawable.image);
        model4.setName("Atri4");
        holder.add(model4);
        Model model5 =new Model();
        model5.setImg(R.drawable.image);
        model5.setName("Atri5");
        holder.add(model5);
        Model model6 =new Model();
        model6.setImg(R.drawable.image);
        model6.setName("Atri6");
        holder.add(model6);
        Model model7 =new Model();
        model7.setImg(R.drawable.image);
        model7.setName("Atri7");
        holder.add(model7);
        Model model8 =new Model();
        model8.setImg(R.drawable.image);
        model8.setName("Atri8");
        holder.add(model8);




        return holder;
    }
}
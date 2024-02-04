package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Blank extends AppCompatActivity {
TextView name;
ImageView logo,image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

         name = (TextView) findViewById(R.id.name);
        logo=(ImageView) findViewById(R.id.logo);
        image=(ImageView) findViewById(R.id.image);
//



    }
}
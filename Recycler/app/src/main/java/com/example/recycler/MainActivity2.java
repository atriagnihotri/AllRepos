package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView textView;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img=(ImageView) findViewById(R.id.dataimage);
        textView=(TextView) findViewById(R.id.dataname);
        img.setImageResource(getIntent().getIntExtra("dataimg",0));
        textView.setText(getIntent().getStringExtra("dataname"));
    }
}
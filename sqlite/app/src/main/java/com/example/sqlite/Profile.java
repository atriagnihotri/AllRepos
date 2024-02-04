package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
TextView name,password,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=findViewById(R.id.name);
        gender=findViewById(R.id.gender);
        password=findViewById(R.id.password);

        profiledata();
    }

    public void profiledata() {
     DbHelper dbHelper=new DbHelper(this);
     UserModel model;
        String profile= getIntent().getStringExtra("key_name");
    ArrayList<UserModel> al= dbHelper.profile(profile);
     model =al.get(0);
     name.setText(model.getName());
     gender.setText(model.getGender());
     password.setText(model.getPassword());
    }
}
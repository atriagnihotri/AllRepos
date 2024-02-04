package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText name,password,gender;
Button register,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          name=findViewById(R.id.name);
          password=findViewById(R.id.password);
          gender=findViewById(R.id.gender);
          register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),login.class);
                startActivity(in);
            }
        });
         DbHelper dbHelper=new DbHelper(getApplicationContext());
          register.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String name1=name.getText().toString();
                  String pass2=password.getText().toString();
                  String gender2=gender.getText().toString();
                  dbHelper.register(name1,pass2,gender2);

                  Toast.makeText(MainActivity.this, "User Registered Successfully!!", Toast.LENGTH_SHORT).show();
                  name.setText("");
                  gender.setText("");
                  password.setText("");

                  Intent intent=new Intent(getApplicationContext(),login.class);
                  startActivity(intent);
              }
          });

    }


}
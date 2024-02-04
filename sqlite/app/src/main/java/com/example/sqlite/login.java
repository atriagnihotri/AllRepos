package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText name,password;
    Button login;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);

        login=findViewById(R.id.login);
         dbHelper=new DbHelper(getApplicationContext());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loggedin();
            }
        });
    }
    public void loggedin(){
        String name1=name.getText().toString();
        String pass2=password.getText().toString();
        boolean loggedin=dbHelper.login(name1,pass2);
        if (loggedin){
            Intent intent=new Intent(getApplicationContext(), Profile.class);
            intent.putExtra("key_name",pass2);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Login Error!!", Toast.LENGTH_SHORT).show();
        }

    }

}
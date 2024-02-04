package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
EditText name,email,phone;
Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        register=findViewById(R.id.register);

        SessionManager sp=new SessionManager(getApplicationContext());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names=name.getText().toString();
                String emails=email.getText().toString();
                String phones=phone.getText().toString();
                sp.CreateSession(names,emails,phones);
                Intent intent=new Intent(Register.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText name,email;
    Button login;
    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        login=findViewById(R.id.login);
        register=findViewById(R.id.register);

        SessionManager sp=new SessionManager(getApplicationContext());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names=name.getText().toString();
                String emails=email.getText().toString();
                boolean log= true;
                if (log){
                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Login.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

    }
}
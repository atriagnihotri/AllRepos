package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView data,phone,email , logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       data=findViewById(R.id.data);
       logout=findViewById(R.id.logout);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
       SessionManager sessionManager=new SessionManager(getApplicationContext());



           data.setText(sessionManager.SessionDetails("Session_Name"));
        phone.setText(sessionManager.SessionDetails("Session_Phone"));
        email.setText(sessionManager.SessionDetails("Session_Email"));

           logout.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   SessionManager sp=new SessionManager(getApplicationContext());
                   sp.LogOut();

               }
           });
    }
}
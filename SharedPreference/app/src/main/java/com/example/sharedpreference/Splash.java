package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SessionManager sp=new SessionManager(getApplicationContext());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    boolean b=sp.SessionCheck();
                    if (b==true){
                        Intent i = new Intent(Splash.this, MainActivity.class);
                        startActivity(i); // invoke the SecondActivity.
                        finish(); // the current activity will get finished.
                    }
                    else {
                        Intent in = new Intent(Splash.this, Login.class);
                        startActivity(in); // invoke the SecondActivity.
                        finish(); // the current activity will get finished.
                    }

            }
        }, 2000);
    }
}
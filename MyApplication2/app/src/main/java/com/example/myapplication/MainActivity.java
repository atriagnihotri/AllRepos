package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomnav;
FrameLayout fm;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        bottomnav=findViewById(R.id.bottomnav);
        fm=findViewById(R.id.frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new home()).commit();
        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if (id==R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,new home()).commit();
                }
                else if (id==R.id.search){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,new search()).commit();
                }
                else if (id==R.id.add){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,new add()).commit();
                }
                else if (id==R.id.user){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,new profile()).commit();
                }



                return true;
            }
        });
    }
}
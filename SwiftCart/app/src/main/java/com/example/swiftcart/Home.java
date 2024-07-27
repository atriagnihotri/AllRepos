package com.example.swiftcart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    FrameLayout fragmentContainer;
    Orders orders;
    Products products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

         fragmentContainer = findViewById(R.id.flFragment);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();
                if(id==R.id.products){
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,new Products()).commit();
                }
                if(id==R.id.orders){
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,new Orders()).commit();
                }

                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.products);


    }
}
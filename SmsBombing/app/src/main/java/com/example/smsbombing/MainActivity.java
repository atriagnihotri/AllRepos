package com.example.smsbombing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText phone, count, message;
    Button target;
    final static int REQUEST_SMS_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // BY Atri ------------------>
        phone = findViewById(R.id.phone);
        count = findViewById(R.id.count);
        message = findViewById(R.id.message);
        target = findViewById(R.id.bomb); // Initialize the target button

        target.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move these lines inside the onClick method
                String countString = count.getText().toString().trim();

                String phones = phone.getText().toString();
                String messages = message.getText().toString();

                if (countString.isEmpty()) {
                    // Display a message to the user indicating that count and interval cannot be empty
                    Toast.makeText(MainActivity.this, "Count and Interval cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    int counti = Integer.parseInt(countString);

                    // Check for runtime permission on devices running Android 23 or higher
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                            // Permission is not granted, request it
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS_PHONE);
                        } else {
                            // Permission is already granted, make the call
                            runThread(phones, counti, messages);
                        }
                    } else {
                        // For devices below Android 23, no runtime permission is required
                        runThread(phones, counti, messages);
                    }
                } catch (NumberFormatException e) {
                    // Handle the case where count or interval cannot be parsed as integers
                    Toast.makeText(MainActivity.this, "Invalid Count or Interval", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void runThread(String phones, int counti, String messages) {
        // You might want to run the threads in the background using runOnUiThread or AsyncTask
        threads threads = new threads(getApplicationContext(), phones, counti, messages);
        threads.run();
    }
}

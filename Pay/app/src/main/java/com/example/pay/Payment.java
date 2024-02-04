package com.example.pay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Payment extends AppCompatActivity {
TextView amountone,amounttwo,name,datetime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        amountone=(TextView) findViewById(R.id.amountone);
        amounttwo=(TextView) findViewById(R.id.amounttwo);
        name=(TextView) findViewById(R.id.name);
        datetime=(TextView) findViewById(R.id.datetime);

        //Date and Time
// on below line we are creating and initializing
        // variable for simple date format.
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm  dd-MM-yyyy");

        // on below line we are creating a variable
        // for current date and time and calling a simple date format in it.
        String currentDateAndTime = sdf.format(new Date());
        datetime.setText(currentDateAndTime);



        String ruppee="₹";
        Intent intent=getIntent();
        String str=intent.getStringExtra("msg_str");
        String nam=intent.getStringExtra("msg_name");
        amountone.setText(ruppee+str);
        amounttwo.setText(ruppee+str);
        name.setText(nam.substring(13,23));


    }
}
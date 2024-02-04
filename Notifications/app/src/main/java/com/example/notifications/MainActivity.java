package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private static final String CHANNEL_ID="MY CHANNEL";
    private static final int NOTIFICATION_ID=1;
    private static final int REQ_CODE=11;
    Notification notification;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);


        Intent inotify=new Intent(getApplicationContext(),MainActivity.class);
        inotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi=PendingIntent.getActivity(this,REQ_CODE,inotify,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             notification=new Notification.Builder(this)
                    .setSmallIcon(R.drawable.credit)
                    .setContentText("New App msg")
                    .setSubText("Message from Atri")
                    .setContentIntent(pi)
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New App msg",NotificationManager.IMPORTANCE_HIGH));
        }
        else{
             notification=new Notification.Builder(this)
                    .setSmallIcon(R.drawable.credit)
                    .setContentText("New App msg")
                    .setContentIntent(pi)
                    .setSubText("Message from Atri")
                    .build();
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm.notify(NOTIFICATION_ID,notification);
            }
        });


    }
}
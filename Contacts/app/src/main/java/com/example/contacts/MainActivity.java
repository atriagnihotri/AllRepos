package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.Manifest;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView contacts;
ArrayList<String> alst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts=(ListView) findViewById(R.id.contactlist);

      alst=new ArrayList<String>();
        fetchcontacts();
    }
    public void fetchcontacts(){

             if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED) {

                 ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},0);

             }
            ContentResolver resolver=getContentResolver();
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] Projection=null; //Used to access colum wise data
        String selection=null;  //Used to access row wise data
        String[] selectionArgs=null; //Used when we want to access the data with criteria
        String order=null;
       Cursor cursor= resolver.query(uri,Projection,selection,selectionArgs,order);
       if(cursor.getCount()>0){

           while (cursor.moveToNext()){
               String name=ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
               String number=ContactsContract.CommonDataKinds.Phone.NUMBER;
               String contacts=name +"\n"+ number;
               alst.add(contacts); //Cursor data is copying to the arraylist

           }
       }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,alst);
        contacts.setAdapter(adapter);
    }
}
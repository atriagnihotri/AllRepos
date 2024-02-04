package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="demodb";
    private static final int DB_VERSION=1;
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
             String CREATE_TABLE="CREATE TABLE register(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,password TEXT,gender TEXT)";
             db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS register");
        onCreate(db);

    }

    public void register(String names,String passwords,String genders){
      SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",names);
        contentValues.put("password",passwords);
        contentValues.put("gender",genders);
        sqLiteDatabase.insert("register",null,contentValues);
        sqLiteDatabase.close();


    }
    boolean loggedin;
    public boolean login(String names,String passwords){
        SQLiteDatabase sqldatabase=this.getReadableDatabase();
        Cursor cursor=sqldatabase.rawQuery("SELECT * FROM register WHERE name='"+names+"' AND password='"+passwords+"'",null);
       if (cursor.moveToFirst()){
           loggedin= true;
       }
       else {
           loggedin= false;
       }
       return loggedin;

    }
    public ArrayList<UserModel> profile(String names){
        SQLiteDatabase sqldatabase=this.getReadableDatabase();
        ArrayList<UserModel> model=new ArrayList<>();
        UserModel userModel=new UserModel();

        String query="SELECT * FROM register WHERE name='"+names+"'";
        Cursor cursor=sqldatabase.rawQuery(query,null);
        if (cursor.moveToFirst()){
            String name=cursor.getString(1);
            String gender=cursor.getString(2);
            String password=cursor.getString(3);
            userModel.setName(name);
            userModel.setGender(gender);
            userModel.setPassword(password);
            model.add(userModel);

        }
     return model;

    }

}

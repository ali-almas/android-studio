package com.example.hp450.databasedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR , age INT(3))");
            myDatabase.execSQL("INSERT INTO users (name,age) VALUES('Ali',20)");
            myDatabase.execSQL("INSERT INTO users (name,age) VALUES('Vusal',18)");

            Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age > 18",null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();

            while (c != null)
            {
                Log.i("UserResults - name" , c.getString(nameIndex));
                Log.i("UserResults - age" , Integer.toString(c.getInt(ageIndex)));

                c.moveToNext();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

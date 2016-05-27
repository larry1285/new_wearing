package com.example.larry.new_wearing;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SQLiteDatabase sqLiteDatabase =getBaseContext().openOrCreateDatabase("sqlite_test.db",MODE_PRIVATE,null);
        // We first get a reference to the Intent that resulted in this activity
        // being started by the Android framework.
        Intent in = getIntent();

        // From the Intent we retrieve the message that was sent from MainActivity
        // Note the use of the same key, "message", to retrieve the message
        String message = in.getStringExtra("message");
        Cursor query=sqLiteDatabase.rawQuery("SELECT * from contacts WHERE name='larry' ",null);
        if(query.moveToFirst()){
            do{
                String name=query.getString(0);
                int phone=query.getInt(1);
                String email=query.getString(2);
                Toast.makeText(getBaseContext(),"Name="+name+" Phone="+phone+" email="+email, Toast.LENGTH_LONG).show();

            }while(query.moveToNext());
        }else{
            Toast.makeText(getBaseContext(),"Error retrieving data",Toast.LENGTH_LONG).show();
        }
        sqLiteDatabase.close();

    }
}

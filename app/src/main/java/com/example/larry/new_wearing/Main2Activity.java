package com.example.larry.new_wearing;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    Button temp_button;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SQLiteDatabase sqLiteDatabase =getBaseContext().openOrCreateDatabase("wearing.db",MODE_PRIVATE,null);
        temp_button=(Button)findViewById(R.id.button2);
        // We first get a reference to the Intent that resulted in this activity
        // being started by the Android framework.
        Intent in = getIntent();

        // From the Intent we retrieve the message that was sent from MainActivity
        // Note the use of the same key, "message", to retrieve the message
        message = in.getStringExtra("message");
        //選衣服
        Cursor query=sqLiteDatabase.rawQuery("SELECT * from cloth WHERE attribute=?",new String[] { message },null);
        if(query.moveToFirst()){

            String name=query.getString(0);
            String color=query.getString(1);
            String attribute=query.getString(2);
            int ivID = getResources().getIdentifier(name , "drawable", getPackageName());
            ImageView iv= (ImageView)findViewById(R.id.imageView2);
            iv.setImageResource(ivID);

        }else{
            Toast.makeText(getBaseContext(),"Error retrieving data",Toast.LENGTH_LONG).show();
        }

        //選褲子
        query=sqLiteDatabase.rawQuery("SELECT * from pants WHERE attribute=?",new String[] { message },null);
        if(query.moveToFirst()){
            String name=query.getString(0);
            String color=query.getString(1);
            String attribute=query.getString(2);
            int ivID = getResources().getIdentifier(name , "drawable", getPackageName());
            ImageView iv= (ImageView)findViewById(R.id.imageView5);
            iv.setImageResource(ivID);

        }else{
            Toast.makeText(getBaseContext(),"Error retrieving data",Toast.LENGTH_LONG).show();
        }
        //選鞋子
        query=sqLiteDatabase.rawQuery("SELECT * from shoes WHERE attribute=?",new String[] { message },null);
        if(query.moveToFirst()){
            String name=query.getString(0);
            String color=query.getString(1);
            String attribute=query.getString(2);
            int ivID = getResources().getIdentifier(name , "drawable", getPackageName());
            ImageView iv= (ImageView)findViewById(R.id.imageView4);
            iv.setImageResource(ivID);

        }else{
            Toast.makeText(getBaseContext(),"Error retrieving data",Toast.LENGTH_LONG).show();
        }

        sqLiteDatabase.close();

        temp_button.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        //選外套
        SQLiteDatabase sqLiteDatabase =getBaseContext().openOrCreateDatabase("wearing.db",MODE_PRIVATE,null);
        Cursor query=sqLiteDatabase.rawQuery("SELECT * from jacket WHERE attribute=?",new String[] { message },null);
        if(query.moveToFirst()){
            String name=query.getString(0);
            String color=query.getString(1);
            String attribute=query.getString(2);
            EditText edit_temperature = (EditText) findViewById(R.id.editText);
            String temperature = edit_temperature.getText().toString();
            int temp=Integer.parseInt(temperature);
            int ivID = getResources().getIdentifier(name , "drawable", getPackageName());
            ImageView iv= (ImageView)findViewById(R.id.imageView6);
            if(attribute.equals("運動"))
                iv.setImageResource(R.drawable.sports_coat);
            else if(temp<23 && temp>13)
                iv.setImageResource(R.drawable.thin_coat);
                //iv.setImageResource(ivID);
            else if(temp<13)
                iv.setImageResource(R.drawable.feather_coat);
            else
                iv.setImageResource(R.drawable.not_recommended);

        }else{
            Toast.makeText(getBaseContext(),"Error retrieving data",Toast.LENGTH_LONG).show();
        }
        sqLiteDatabase.close();
    }
}

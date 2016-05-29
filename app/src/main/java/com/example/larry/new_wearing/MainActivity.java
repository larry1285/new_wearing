package com.example.larry.new_wearing;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    ImageView class_pic;
    ImageView movie_pic;
    ImageView shopping_pic;
    ImageView singlesmixer_pic;
    ImageView workout_pic;
    ImageView formal_pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase sqLiteDatabase =getBaseContext().openOrCreateDatabase("wearing.db",MODE_PRIVATE,null);
        //drop all the tables(just for now)
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cloth");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS pants");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS shoes");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS jacket");

        //insert all the datas again(just for now)
        sqLiteDatabase.execSQL("CREATE TABLE cloth(name TEXT,color TEXT,attribute TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE pants(name TEXT,color TEXT,attribute TEXT,length TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE shoes(name TEXT,color TEXT,attribute TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE jacket(name TEXT,color TEXT,attribute TEXT,temperature TEXT)");


        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('poloshirt','紅','舒適')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('fashion_t','白','舒適')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('plain_t','黑','帥')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('shirt','黑','運動')");

        sqLiteDatabase.execSQL("INSERT INTO pants VALUES('leisure_pants','灰','舒適','短')");
        sqLiteDatabase.execSQL("INSERT INTO pants VALUES('narrow_pants','卡其色','帥','長')");
        sqLiteDatabase.execSQL("INSERT INTO pants VALUES('sports_pants','黑','運動','短')");
        sqLiteDatabase.execSQL("INSERT INTO pants VALUES('ball_pants','紅','運動','短')");

        sqLiteDatabase.execSQL("INSERT INTO shoes VALUES('sneaker','黑','運動')");
        sqLiteDatabase.execSQL("INSERT INTO shoes VALUES('canvas','灰','帥')");
        sqLiteDatabase.execSQL("INSERT INTO shoes VALUES('sandals','咖啡色','舒適')");
        sqLiteDatabase.execSQL("INSERT INTO shoes VALUES('leather_shoes','黑','正式')");

        sqLiteDatabase.execSQL("INSERT INTO jacket VALUES('thin_coat','藍','舒適','凉')");
        sqLiteDatabase.execSQL("INSERT INTO jacket VALUES('feather_coat','灰','舒適','寒')");
        sqLiteDatabase.execSQL("INSERT INTO jacket VALUES('sports_coat','白','運動','涼')");


        sqLiteDatabase.close();



        class_pic=(ImageView)findViewById(R.id.class_image);
        movie_pic=(ImageView)findViewById(R.id.movie_image);
        shopping_pic=(ImageView)findViewById(R.id.shopping_image);
        singlesmixer_pic=(ImageView)findViewById(R.id.singlesmixer_image);
        workout_pic=(ImageView)findViewById(R.id.workout_image);
        formal_pic=(ImageView)findViewById(R.id.formal_image);

        class_pic.setOnClickListener(this);
        movie_pic.setOnClickListener(this);
        shopping_pic.setOnClickListener(this);
        singlesmixer_pic.setOnClickListener(this);
        workout_pic.setOnClickListener(this);
        formal_pic.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent in= new Intent(MainActivity.this,Main2Activity.class);
        switch (view.getId()) {
            case R.id.class_image:
                // create a new intent. The first parameter is the Context which is the current Activity.
                // Hence we use "this". The second parameter is the Activity class that we wish to start.
                // Hence it is specified as ShowMessage.class
                in.putExtra("message", "舒適");
                // Add the message as a payload to the Intent. We add data to be carried by the intern using
                // the putExtra() methods. The data is specified as a key-value pair. The first parameter is
                // the key, specified as a string, and the second parameter is the value.
                break;
            case R.id.movie_image:
                in.putExtra("message","舒適");
                break;
            case R.id.shopping_image:
                in.putExtra("message","舒適");
                break;
            case R.id.singlesmixer_image:
                in.putExtra("message","帥");
                break;
            case R.id.workout_image:
                in.putExtra("message","運動");
                break;
            case R.id.formal_image:
                in.putExtra("message","正式");
                break;
            default:
                break;
        }
        startActivity(in);
    }
}


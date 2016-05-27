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


        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('Polo ','紅','舒適')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('潮T','白','舒適')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('素T','黑','帥')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('潮T','白','舒適')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('襯衫','黑','帥')");

        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('休閒短褲','灰','舒適','短')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('窄庫','卡其色','帥','長')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('運動褲','黑','運動','短')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('球褲','紅','運動','短')");

        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('球鞋','黑','運動')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('凡布鞋','灰','帥')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('涼鞋','咖啡色','舒適')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('皮鞋','黑','正式')");

        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('薄外套','藍','舒適','凉')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('羽絨外套','灰','舒適','寒')");
        sqLiteDatabase.execSQL("INSERT INTO cloth VALUES('運動外套','白','運動','涼')");


        sqLiteDatabase.close();



        class_pic=(ImageView)findViewById(R.id.class_image);
        class_pic.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.class_image:
                // create a new intent. The first parameter is the Context which is the current Activity.
                // Hence we use "this". The second parameter is the Activity class that we wish to start.
                // Hence it is specified as ShowMessage.class
                Intent in = new Intent(MainActivity.this,Main2Activity.class);
                in.putExtra("message", "comfortable");
                // Add the message as a payload to the Intent. We add data to be carried by the intern using
                // the putExtra() methods. The data is specified as a key-value pair. The first parameter is
                // the key, specified as a string, and the second parameter is the value.
                startActivity(in);
                break;
            case R.id.movie_image:
                Intent in = new Intent(MainActivity.this,Main2Activity.class);
                in.putExtra("message","comfortable");
                startActivity(in);
            case R.id.shopping_image:
                Intent in = new Intent(MainActivity.this,Main2Activity.class);
                in.putExtra("message","fashion");
                startActivity(in);
            case R.id.singlesmixer_image:
                Intent in = new Intent(MainActivity.this,Main2Activity.class);
                in.putExtra("message","fashion");
                startActivity(in);
            case R.id.workout_image:
                Intent in = new Intent(MainActivity.this,Main2Activity.class);
                in.putExtra("message","workout");
                startActivity(in);
            case R.id.formal_image:
                Intent in = new Intent(MainActivity.this,Main2Activity.class);
                in.putExtra("message","formal");
                startActivity(in);
            default:
                break;
        }
    }
}


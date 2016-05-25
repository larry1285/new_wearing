package com.example.larry.new_wearing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent in = getIntent();
        String message = in.getStringExtra("message");

        // Get the reference to the TextView on the ShowMessage UI
        TextView textMessage = (TextView) findViewById(R.id.textView10);

        // set the text of the TextView to display the incoming greeting message
        textMessage.setText(message);
    }
}

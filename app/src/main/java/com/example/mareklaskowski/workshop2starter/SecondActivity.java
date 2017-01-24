package com.example.mareklaskowski.workshop2starter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button ok_button = (Button)findViewById(R.id.ok_button);
        ok_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //let's pull the text out of the text box and put it into the intent as the "message" extra
                EditText editText = (EditText) findViewById(R.id.editText);
                String userMessage = editText.getText().toString();
                //create an intent to reply back to the MainActivity
                Intent replyIntent = new Intent();
                //set the result for this activity
                replyIntent.putExtra("message", userMessage);
                //post the reply intent, and dend the activity
                setResult(Activity.RESULT_OK, replyIntent);
            }
        });

    }
}

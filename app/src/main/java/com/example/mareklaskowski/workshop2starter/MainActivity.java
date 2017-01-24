package com.example.mareklaskowski.workshop2starter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        once the activity is created, let's assign some code to the Button when it is clicked
        recall Context.findViewByID - returns a View
        it expects an argument - an identifier from the R static class
        */
        Button a2_button = (Button) findViewById(R.id.a2_button);
        /*
        add an onClickListener to the button by assigning a so-called "anonymous subclass" of OnClickListener
        we will override the OnClickListner's onClick() method inside the constructor call.
        notice that here we will pass the newly instatiated OnClickListner to the setOnClickListener method instead of storing the reference
        at the same time we override the onClick method -> this is a common pattern you see in Java "in the wild"
         */
        a2_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //typically the pattern is to call a method in our Activity.
                //for today, let's just do the work in here..
                //let's get the button to start SecondActivity (for result)
                //we need to create an Intent
                Intent a2intent = new Intent("com.seneca.lab2b.marek");
                /*
                startActivityForResult expects both an intent and a request code so that you can match up the reply
                with your original request
                 */
                startActivityForResult(a2intent, 1);
            }
        });

        //TODO: add an onClickListener for your a3_button!
        //TODO: use startActivity instead of startActivityForResult!
        //TODO: also use an EXPLICIT intent instead of IMPLICIT
    }

    /* onActivityResult will be called by the Android framework once the activity we started
    with startActivityForResult completes. We are passed the same requestCode we passed to startActivityForResult
    and a resultCode that indicates whether the user completed the Activity or pressed Back to cancel
    */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result = "RESULT NOT SET";
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                //if everything is alright, extract the message from the Intent returned
                //from the Activity we started with startActivityForResult
                result = data.getStringExtra("message");
            }else if(resultCode == Activity.RESULT_CANCELED){
                result = "user cancelled";
            }
        }else{
            Log.e("lab2", "SOMETHNG WENT REALLY WRONG");
        }
        //get the TextView from the layout and set its text
        TextView text = (TextView)findViewById(R.id.textView);
        text.setText(result);

        //example of sending a Toast
        Context context = getApplicationContext();
        String toast_text = "You are cool " + result;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, toast_text, duration);
        toast.show();

    }
}

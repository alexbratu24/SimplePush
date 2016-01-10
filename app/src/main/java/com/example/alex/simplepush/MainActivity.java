package com.example.alex.simplepush;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.parse.ParseObject;
import com.parse.ParsePush;

public class MainActivity extends AppCompatActivity  {

  private Button sendPush;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendPush= (Button)findViewById(R.id.buttonPush);


        sendPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParsePush push = new ParsePush();
                push.setChannel("Munti");
                push.setMessage("Bratu....");
                push.sendInBackground();
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("foo", "bar");
                testObject.saveInBackground();
            }
        });

    }
/*
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonPush:
                ParsePush push = new ParsePush();
                push.setChannel("Munti");
                push.setMessage("Bratu....");
                push.sendInBackground();
                break;
            default:
                break;
        }
    }   */
}

package com.example.alex.simplepush;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParsePush;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity  {

  private Button sendPush;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendPush= (Button)findViewById(R.id.buttonPush);
      //  String parse_app_id = Integer.toString(R.string.parse_app_id);
      //  String parse_client_key = Integer.toString(R.string.parse_client_key);
       // Parse.initialize(this,"IkBygdHGsGviUnWPe2cKDJ26cDzddcUO1bfQFv3g","O89ESk7o1VJjVMpey4QbqH3UrEirdKL43slheuZy");
        Parse.initialize(this,"fR37pLYx7thotUP606CIiu3efypK3U0otl5F0Won","C0iZxMhVdhsru8CyjJgJE4AyuozOWgG760D8fodI");
        ParseInstallation.getCurrentInstallation().saveInBackground();
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

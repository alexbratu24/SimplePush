package com.example.alex.simplepush;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import adapters.TempAdapter;
import model.Temperature;

public class TempListActivity extends AppCompatActivity {

    ListView tempList ;
    ArrayList<Temperature> listItems;
    TempAdapter tempAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_list);
        Parse.initialize(this, "fR37pLYx7thotUP606CIiu3efypK3U0otl5F0Won", "C0iZxMhVdhsru8CyjJgJE4AyuozOWgG760D8fodI");
        ParseInstallation.getCurrentInstallation().saveInBackground();
        tempList = (ListView)(findViewById(R.id.listView));
        listItems = new ArrayList<Temperature>();
        tempAdapter = new TempAdapter(this.getApplicationContext(),listItems);
        tempList.setAdapter(tempAdapter);
        getTemp();
    }
    public void getTemp()
    {
        Date today = new Date();
        today.setDate(today.getDay() - 1);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Temperature");
        query.whereGreaterThan("createdAt",today);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    for(ParseObject obj: objects)
                    {

                        Date crAt = obj.getCreatedAt();
                        String temper = String.valueOf(obj.getNumber("temp"));

                        Temperature t = new Temperature(crAt,Float.valueOf(temper));
                         listItems.add(t);
                        tempAdapter.add(t);

                    }

                } else {
                    Toast.makeText(TempListActivity.this, "I received sn Error.", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}

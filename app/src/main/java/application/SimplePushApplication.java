package application;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by Alexandru on 1/10/2016.
 */
public class SimplePushApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "fR37pLYx7thotUP606CIiu3efypK3U0otl5F0Won", "C0iZxMhVdhsru8CyjJgJE4AyuozOWgG760D8fodI");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}

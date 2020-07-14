package com.nathanielchavez.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("FXl2X9FTgNiGzdKcZSzQBh0Ksu6cv8xqAZcmqgtP")
                // if defined
                .clientKey("XxGvzcpcBu1FuVJ3V4KwSVTUJDlj4qMYDIar22iB")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}

package com.example.instagram;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("EAtTzIm3EYc6pyWYRyFSmTZLcLxxmugbP6vXdz32")
                .clientKey("8Y72tiIvXWKNw8V3mAdtEXdvMZM43bUIxDWXLts7")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}

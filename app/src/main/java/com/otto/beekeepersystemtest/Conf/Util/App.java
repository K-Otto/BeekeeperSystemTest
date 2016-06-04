package com.otto.beekeepersystemtest.Conf.Util;

import android.app.Application;
import android.content.Context;

/**
 * Created by 212026992 on 6/3/2016.
 */
public class App extends Application {
    private static Context context;

    private static App singleton;

    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
        singleton = this;
    }

    public static Context getAppContext() {
        return App.context;
    }

    public static final String TAG = App.class
            .getSimpleName();


    public static synchronized App getInstance() {
        return singleton;
    }
}
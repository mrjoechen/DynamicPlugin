package com.chenqiao.dynamicplugin;

import android.app.Application;

/**
 * Created by chenqiao on 2019-10-10.
 * e-mail : mrjctech@gmail.com
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            InjectUtil.inject(this, getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

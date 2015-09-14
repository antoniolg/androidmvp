package com.antonioleiva.mvpexample.app;

import android.app.Application;

import com.antonioleiva.mvpexample.app.di.ApplicationComponent;
import com.antonioleiva.mvpexample.app.di.DaggerApplicationComponent;
import com.antonioleiva.mvpexample.app.di.MvpExampleAppModule;

/**
 * Created by venkatesh on 11/9/15.
 */
public class MvpExampleApplication extends Application {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder().mvpExampleAppModule(new MvpExampleAppModule()).build();
    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}

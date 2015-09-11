package com.antonioleiva.mvpexample.app;

import android.app.Activity;
import android.os.Bundle;

import com.antonioleiva.mvpexample.app.di.ActivityComponent;
import com.antonioleiva.mvpexample.app.di.ApplicationComponent;
import com.antonioleiva.mvpexample.app.di.DaggerActivityComponent;
import com.antonioleiva.mvpexample.app.di.MvpActivityModule;
import com.antonioleiva.mvpexample.app.di.MvpPresenterModule;

/**
 * Created by venkatesh on 11/9/15.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MvpExampleApplication) getApplication()).getComponent();
    }

    protected MvpActivityModule getActivityModule() {
        return new MvpActivityModule(this);
    }

    protected MvpPresenterModule getPresenterModule() {
        return new MvpPresenterModule();
    }

    public ActivityComponent initializeInjector() {
        return DaggerActivityComponent.builder()
                .applicationComponent(((MvpExampleApplication) getApplication()).getComponent())
                .mvpActivityModule(getActivityModule())
                .mvpPresenterModule(getPresenterModule())
                .build();
    }
}

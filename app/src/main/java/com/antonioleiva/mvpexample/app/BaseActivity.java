package com.antonioleiva.mvpexample.app;

import android.app.Activity;
import android.os.Bundle;

import com.antonioleiva.mvpexample.app.dependency.ApplicationComponent;
import com.antonioleiva.mvpexample.app.dependency.MvpActivityModule;

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
}

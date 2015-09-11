package com.antonioleiva.mvpexample.app.dependency;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by venkatesh on 11/9/15.
 */

@Module
public class MvpActivityModule {
    private final Activity activity;

    public MvpActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides Activity provideActivity() {
        return this.activity;
    }
}

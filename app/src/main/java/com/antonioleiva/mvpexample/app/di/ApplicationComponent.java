package com.antonioleiva.mvpexample.app.di;

import com.antonioleiva.mvpexample.app.BaseActivity;
import com.antonioleiva.mvpexample.app.MvpExampleApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by venkatesh on 11/9/15.
 */

@Singleton
@Component(modules = {MvpExampleAppModule.class})
public interface ApplicationComponent {
    void inject(MvpExampleApplication mvpExampleApplication);
    void inject(BaseActivity baseActivity);
}

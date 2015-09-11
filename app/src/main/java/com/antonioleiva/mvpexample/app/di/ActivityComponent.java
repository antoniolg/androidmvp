package com.antonioleiva.mvpexample.app.di;

import com.antonioleiva.mvpexample.app.Login.LoginActivity;
import com.antonioleiva.mvpexample.app.main.MainActivity;
import com.antonioleiva.mvpexample.app.scopes.PerActivity;

import dagger.Component;

/**
 * Created by venkatesh on 11/9/15.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {MvpActivityModule.class, MvpPresenterModule.class})
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);
    void inject(MainActivity mainActivity);
}

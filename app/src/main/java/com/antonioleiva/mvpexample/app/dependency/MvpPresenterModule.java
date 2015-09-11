package com.antonioleiva.mvpexample.app.dependency;

import android.app.Activity;

import com.antonioleiva.mvpexample.app.Login.LoginInteractor;
import com.antonioleiva.mvpexample.app.Login.LoginInteractorImpl;
import com.antonioleiva.mvpexample.app.Login.LoginPresenter;
import com.antonioleiva.mvpexample.app.Login.LoginPresenterImpl;
import com.antonioleiva.mvpexample.app.Login.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by venkatesh on 11/9/15.
 */

@Module
public class MvpPresenterModule {

    @Provides
    LoginPresenter provideLoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        return new LoginPresenterImpl(loginView, loginInteractor);
    }

    @Provides
    LoginView provideLoginView(Activity activity) {
        return (LoginView) activity;
    }

    @Provides
    LoginInteractor provideLoginInteractor() {
        return new LoginInteractorImpl();
    }
}

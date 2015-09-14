package com.antonioleiva.mvpexample.app.di;

import android.app.Activity;

import com.antonioleiva.mvpexample.app.Login.LoginInteractor;
import com.antonioleiva.mvpexample.app.Login.LoginInteractorImpl;
import com.antonioleiva.mvpexample.app.Login.LoginPresenter;
import com.antonioleiva.mvpexample.app.Login.LoginPresenterImpl;
import com.antonioleiva.mvpexample.app.Login.LoginView;
import com.antonioleiva.mvpexample.app.main.FindItemsInteractor;
import com.antonioleiva.mvpexample.app.main.FindItemsInteractorImpl;
import com.antonioleiva.mvpexample.app.main.MainPresenter;
import com.antonioleiva.mvpexample.app.main.MainPresenterImpl;
import com.antonioleiva.mvpexample.app.main.MainView;

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
    MainPresenter provideMainPresenter(MainView mainView, FindItemsInteractor findItemsInteractor) {
        return new MainPresenterImpl(mainView, findItemsInteractor);
    }

    @Provides
    FindItemsInteractor provideFindItemsInteractor() {
        return new FindItemsInteractorImpl();
    }

    @Provides
    MainView provideMainView(Activity activity) {
        return (MainView) activity;
    }
}

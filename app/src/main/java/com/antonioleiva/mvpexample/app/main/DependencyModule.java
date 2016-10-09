package com.antonioleiva.mvpexample.app.main;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by a.hayati on 10/5/2016.
 */
@Module
public class DependencyModule {
    MyApplication myApplication;

    public DependencyModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Provides
    @Singleton
    MyApplication provideApplication() {
        return myApplication;
    }

    @Singleton
    @Provides
    FindItemsInteractor provideFindItemsInteractor() {
        return new FindItemsInteractorImpl();
    }

    @Singleton
    @Provides
    MainPresenter provideMainPresenter(FindItemsInteractor findItemsInteractor) {
        return new MainPresenterImpl(findItemsInteractor);
    }
}

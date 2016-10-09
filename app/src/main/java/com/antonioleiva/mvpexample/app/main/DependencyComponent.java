package com.antonioleiva.mvpexample.app.main;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by a.hayati on 10/5/2016.
 */
@Singleton
@Component(modules = {DependencyModule.class})
public interface DependencyComponent {
    MyApplication provideApplication();

    MainPresenter provideMainPresenter();

    FindItemsInteractor provideFindItemsInteractor();

    void inject(MainActivity mainActivity);

    void inject(MainViewImpl mainViewImpl);

//    void inject(Context context);
}

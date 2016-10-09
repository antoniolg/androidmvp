package com.antonioleiva.mvpexample.app.main;

import android.app.Application;
import android.view.View;

import javax.inject.Inject;

/**
 * Created by a.hayati on 10/5/2016.
 */
public class MyApplication extends Application {
    private DependencyComponent dependencyComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        dependencyComponent = DaggerDependencyComponent.builder().dependencyModule(new DependencyModule(this)).build();
    }

    public DependencyComponent getDependencyComponent() {
        return dependencyComponent;
    }
}

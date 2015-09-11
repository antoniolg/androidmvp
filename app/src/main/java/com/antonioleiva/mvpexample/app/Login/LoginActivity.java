/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.antonioleiva.mvpexample.app.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.antonioleiva.mvpexample.app.BaseActivity;
import com.antonioleiva.mvpexample.app.MvpExampleApplication;
import com.antonioleiva.mvpexample.app.R;
import com.antonioleiva.mvpexample.app.dependency.ActivityComponent;
import com.antonioleiva.mvpexample.app.dependency.DaggerActivityComponent;
import com.antonioleiva.mvpexample.app.dependency.MvpActivityModule;
import com.antonioleiva.mvpexample.app.dependency.MvpPresenterModule;
import com.antonioleiva.mvpexample.app.main.MainActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {
    private ActivityComponent activityComponent;

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    @Inject LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
        activityComponent.inject(this);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override public void onClick(View v) {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }

    private void initializeInjector() {
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((MvpExampleApplication) getApplication()).getComponent())
                .mvpActivityModule(getActivityModule())
                .mvpPresenterModule(new MvpPresenterModule())
                .build();
    }
}

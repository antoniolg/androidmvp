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

package com.antonioleiva.mvpexample.app.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.antonioleiva.mvpexample.app.BaseActivity;
import com.antonioleiva.mvpexample.app.MvpExampleApplication;
import com.antonioleiva.mvpexample.app.R;
import com.antonioleiva.mvpexample.app.di.ActivityComponent;
import com.antonioleiva.mvpexample.app.di.DaggerActivityComponent;
import com.antonioleiva.mvpexample.app.di.MvpPresenterModule;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView, AdapterView.OnItemClickListener {
    private ActivityComponent activityComponent;

    private ListView listView;
    private ProgressBar progressBar;
    @Inject MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
        activityComponent.inject(this);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress);

    }

    @Override protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override public void setItems(List<String> items) {
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(position);
    }

    private void initializeInjector() {
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .mvpActivityModule(getActivityModule())
                .mvpPresenterModule(new MvpPresenterModule())
                .build();
    }
}

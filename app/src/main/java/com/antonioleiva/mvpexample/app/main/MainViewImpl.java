package com.antonioleiva.mvpexample.app.main;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.antonioleiva.mvpexample.app.R;

import java.util.List;

/**
 * Created by a.hayati on 10/8/2016.
 */
public class MainViewImpl extends Fragment implements MainView, AdapterView.OnItemClickListener {

    private View rootView;
    private ListView listView;
    private ProgressBar progressBar;
    private MainPresenter mainPresenter;

    @SuppressLint("ValidFragment")
    public MainViewImpl(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
        mainPresenter.setView(this);
    }

    public MainViewImpl() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        ((MyApplication) getActivity().getApplication()).getDependencyComponent().inject
                (this);
        rootView = inflater.inflate(R.layout.main_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress);
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mainPresenter.onItemClicked(position);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {
        listView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,
                items));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
}

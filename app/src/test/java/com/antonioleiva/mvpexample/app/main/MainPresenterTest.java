package com.antonioleiva.mvpexample.app.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    MainView view;
    @Mock
    FindItemsInteractor interactor;

    private MainPresenterImpl presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new MainPresenterImpl(view, interactor);
    }

    @Test
    public void checkIfShowsProgressOnResume() {
        presenter.onResume();
        verify(view, times(1)).showProgress();
    }

    @Test
    public void checkIfShowsMessageOnItemClick() {
        presenter.onItemClicked(1);
        verify(view, times(1)).showMessage(anyString());
    }

    @Test
    public void checkIfRightMessageIsDisplayed() {
        ArgumentCaptor<String> captor = forClass(String.class);
        presenter.onItemClicked(1);
        verify(view, times(1)).showMessage(captor.capture());
        assertThat(captor.getValue(), is("Position 2 clicked"));
    }

    @Test
    public void checkIfViewIsReleasedOnDestroy() {
        presenter.onDestroy();
        assertNull(presenter.getMainView());
    }

    @Test
    public void checkIfItemsArePassedToView() {
        List<String> items = Arrays.asList("Model", "View", "Controller");
        presenter.onFinished(items);
        verify(view, times(1)).setItems(items);
        verify(view, times(1)).hideProgress();
    }
}

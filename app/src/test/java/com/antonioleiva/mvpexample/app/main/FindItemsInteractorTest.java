package com.antonioleiva.mvpexample.app.main;

import com.antonioleiva.mvpexample.app.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class FindItemsInteractorTest {

    private FindItemsInteractor interactor;

    @Before public void setUp() {
        interactor = new FindItemsInteractorImpl();
    }

    @Test public void checkIfItemsAreReturned() throws InterruptedException {
        final CountDownLatch countDown = new CountDownLatch(1);
        FindItemsInteractor.OnFinishedListener listener = new FindItemsInteractor.OnFinishedListener() {
            @Override
            public void onFinished(List<String> items) {
                assertThat(items.size(), is(10));
                assertThat(items.get(0), is("Item 1"));
                assertThat(items.get(9), is("Item 10"));
                countDown.countDown();
            }
        };
        interactor.findItems(listener);
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();
        countDown.await();
    }
}

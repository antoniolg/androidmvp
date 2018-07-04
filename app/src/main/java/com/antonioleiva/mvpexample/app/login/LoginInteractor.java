package com.antonioleiva.mvpexample.app.login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(() -> {
            if (TextUtils.isEmpty(username)) {
                listener.onUsernameError();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                listener.onPasswordError();
                return;
            }
            listener.onSuccess();
        }, 2000);
    }
}

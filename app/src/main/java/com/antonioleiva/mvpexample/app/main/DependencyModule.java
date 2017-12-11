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

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DependencyModule {
    @Singleton
    @Provides
    MainViewImpl provideMainViewImpl(MainPresenter mainPresenter) {
        return new MainViewImpl(mainPresenter);
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

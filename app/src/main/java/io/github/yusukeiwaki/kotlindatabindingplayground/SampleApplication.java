package io.github.yusukeiwaki.kotlindatabindingplayground;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build());
    }
}

package satlaa.desijewellery.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

public class CustomApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "hi"));
    }

}

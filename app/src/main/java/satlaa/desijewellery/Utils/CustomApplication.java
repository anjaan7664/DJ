package satlaa.desijewellery.Utils;

import android.app.Application;
import android.content.res.Configuration;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLanguage();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        initLanguage();
    }

    private void initLanguage() {
        String ul = LanguageHelper.getUserLanguage(this);
        // if null the language doesn't need to be changed as the user has not chose one.
        if (ul != null) {
            LanguageHelper.updateLanguage(this, ul);
        }
    }
}

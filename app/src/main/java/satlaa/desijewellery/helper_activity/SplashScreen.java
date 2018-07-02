package satlaa.desijewellery.helper_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.google.firebase.analytics.FirebaseAnalytics;

import satlaa.desijewellery.activities.MainActivity;
import satlaa.desijewellery.R;


public class SplashScreen extends Activity {
    private FirebaseAnalytics mFirebaseAnalytics;
    ProgressBar mprogressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        }, 1000);
    }
}
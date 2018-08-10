package satlaa.desijewellery.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.analytics.FirebaseAnalytics;

import satlaa.desijewellery.R;
import satlaa.desijewellery.utils.LocaleHelper;

public class Silver_Jewellery extends AppCompatActivity {
    ImageView imagebutton;
    private InterstitialAd mInterstitialAd;
    Button button;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silver_jewellery);
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9733613923055204/6428159631");
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener(){
            public void onAdClosed(){
                finish();
            }
        });

        button = (Button) findViewById(R.id.silver_paayal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Silver_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "silver_paayal");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.silver_fancy_paayal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Silver_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "silver_fancy_paayal");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.silver_kandora);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Silver_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "silver_kandora");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.silver_halfKandora);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Silver_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "silver_half_kandora");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.silver_bracelate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Silver_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "silver_bracelate");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.silver_bangles);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Silver_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "silver_bangles");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.silver_idol);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Silver_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "silver_idol");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.silver_kada);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Silver_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "silver_kada");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.silver_bartan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Silver_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "silver_bartan");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.silver_others);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Silver_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "silver_others");
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

        }else{
            super.onBackPressed();
        }


    }
}

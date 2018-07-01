package satlaa.desijewellery.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;

import satlaa.desijewellery.HelperActivity.DJPhotos;
import satlaa.desijewellery.R;
import satlaa.desijewellery.HelperActivity.Webview;

public class Emboss extends AppCompatActivity {
    ImageView imagebutton;
    private InterstitialAd mInterstitialAd;
    Button button;
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emboss);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-9733613923055204~2060000795");
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9733613923055204/6428159631");
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener(){
            public void onAdClosed(){
                finish();
            }
        });

        button = (Button) findViewById(R.id.emboss_aad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, DJPhotos.class);
                intent.putExtra("table", "emboss_aad");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_bangles);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, DJPhotos.class);
                intent.putExtra("table", "emboss_bangles");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_bhujbandh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, DJPhotos.class);
                intent.putExtra("table", "emboss_bhujbandh");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_jhoomariya);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, DJPhotos.class);
                intent.putExtra("table", "emboss_jhoomariya");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_mangalsutra);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, DJPhotos.class);
                intent.putExtra("table", "emboss_mangalsutra");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_necklace);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, DJPhotos.class);
                intent.putExtra("table", "emboss_necklace");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_bala);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, DJPhotos.class);
                intent.putExtra("table", "emboss_bala");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_rakhdi_set);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, DJPhotos.class);
                intent.putExtra("table", "emboss_rakhdi_set");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_ring);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, DJPhotos.class);
                intent.putExtra("table", "emboss_ladies_ring");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_ram_navmi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, DJPhotos.class);
                intent.putExtra("table", "emboss_ram_navmi");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_bala_jhela);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, DJPhotos.class);
                intent.putExtra("table", "emboss_bala&jhela");
                startActivity(intent);
            }
        });  button = (Button) findViewById(R.id.emboss_baajubandh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, DJPhotos.class);
                intent.putExtra("table", "emboss_baajubandh");
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

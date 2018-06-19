package satlaa.desijewellery;

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
                Intent intent = new Intent(Emboss.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/emboss/aad.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_bangles);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/emboss/bangles.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_bhujbandh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/emboss/bhujbandh.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_jhoomariya);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/emboss/jhoomariya.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_mangalsutra);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/emboss/mangalsutra.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_necklace);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/emboss/necklace.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_bala);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/emboss/bala.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_rakhdi_set);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/emboss/rakhdi_set.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_ring);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/emboss/ladies_ring.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_ram_navmi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/emboss/ram_navmi.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.emboss_bala_jhela);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/emboss/bala+jhela.php");
                startActivity(intent);
            }
        });  button = (Button) findViewById(R.id.emboss_baajubandh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emboss.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/emboss/bajubandh.php");
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

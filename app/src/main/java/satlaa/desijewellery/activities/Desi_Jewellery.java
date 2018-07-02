package satlaa.desijewellery.activities;

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

import satlaa.desijewellery.R;
import satlaa.desijewellery.helper_activity.DJPhotos;

public class Desi_Jewellery extends AppCompatActivity {
    ImageView imagebutton;
    Button button;
    InterstitialAd interstitialAd;
     FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desi_jewellery);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        MobileAds.initialize(getApplicationContext(),
                getString(R.string.admob_app_id));

        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9733613923055204/6392323008");
        interstitialAd.loadAd(adRequest);
        interstitialAd.setAdListener(new AdListener() {
            public void onAdClosed() {
                finish();
            }
        });

        button = (Button) findViewById(R.id.desi_new_photos);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "new_photos");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_aad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "aad");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_desi_aad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "desi_aad");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_mini_aad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "mini_aad");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bangles);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "bangles");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_baali);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "baali");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bhujbandh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "Bhujbandh");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_baajubandh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "baajubandh");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bracelate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "bracelate");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_chain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "chain");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_chik);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "chick");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_hathphool);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "hathphool");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_jhoomariya);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "jhoomariya");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_kandora);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "kandora");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_mangalsutra);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "mangalsutra");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_nath);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "nath");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_necklace);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "necklace");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_jodha_haar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "jodha_haar");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_punach);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "punach");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_nogariya);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "nogariya");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bala);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "bala");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bala_jhela);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "bala&jhela");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_pendal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "pendal");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_rakhdi_set);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "rakhdi_set");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_rakhdi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "rakhdi");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bena);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "bena");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bor);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "bor");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_ladies_ring);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "ladies_ring");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_gents_ring);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "gents_ring");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_fancy_ring);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "fancy_ring");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_ram_navmi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "ram_navmi");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_sohan_kanthi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "sohan_kanthi");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_sheeshphool);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "sheeshphool");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_thusi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "thusi");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_timaniya);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "timaniya");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_teeka);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "teeka");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_others);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "others");
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.desi_unique);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, DJPhotos.class);
                intent.putExtra("table", "unique");
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}

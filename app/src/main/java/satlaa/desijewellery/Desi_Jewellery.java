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

public class Desi_Jewellery extends AppCompatActivity {
    ImageView imagebutton;
    Button button;
    InterstitialAd interstitialAd;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desi_jewellery);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-9733613923055204~2060000795");

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
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/new_photos.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_aad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/aad.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_desi_aad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/desi_aad.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_mini_aad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/mini_aad.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bangles);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/bangles.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_baali);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/baali.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bhujbandh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/bhujbandh.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_baajubandh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/bajubandh.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bracelate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/bracelate.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_chain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/chain.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_chik);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/chik_set.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_hathphool);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/hathphool.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_jhoomariya);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/jhoomariya.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_kandora);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/kandora.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_mangalsutra);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/mangalsutra.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_nath);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/nath.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_necklace);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/necklace.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_jodha_haar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/jodha_haar.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_punach);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/punach.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_nogariya);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/nogariya.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bala);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/bala.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bala_jhela);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/bala+jhela.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_pendal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/pendal.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_rakhdi_set);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/rakhdi_set.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_rakhdi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/rakhdi.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bena);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/bena.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_bor);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/bor.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_ladies_ring);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/ladies_ring.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_gents_ring);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/gents_ring.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_fancy_ring);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/fancy_ring.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_ram_navmi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/ram_navmi.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_sohan_kanthi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/sohan_kanthi.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_sheeshphool);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/sheesh_phool.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_thusi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/thusi.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_timaniya);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/timaniya.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_teeka);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/teeka.php");
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.desi_others);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://www.desijewel.in/desi/others.php");
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.desi_unique);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Desi_Jewellery.this, Webview.class);
                intent.putExtra("link", "https://desijewel.in/desi/unique.php");
                startActivity(intent);
            }
        });



    }

    @Override
    public void onBackPressed() {
            super.onBackPressed();


    }
}

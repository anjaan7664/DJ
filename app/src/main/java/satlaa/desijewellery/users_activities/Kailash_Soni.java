package satlaa.desijewellery.users_activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.analytics.FirebaseAnalytics;

import satlaa.desijewellery.R;

public class Kailash_Soni extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_kailash_soni);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        ImageButton imageButton = (ImageButton) findViewById(R.id.btn_kailash_fb);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fi = openFa(Kailash_Soni.this);
                startActivity(fi);
            }
        });

        ImageButton imf = (ImageButton) (findViewById(R.id.btn_kailash_dialer));
        imf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:+919571790992"));
                startActivity(i);
            }
        });

    }
    public static  Intent openFa(Context context){
        try{
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana",0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/100009575509192"));
        }catch (Exception e ){
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/profile.php?id=100009575509192"));
        }
    }

}

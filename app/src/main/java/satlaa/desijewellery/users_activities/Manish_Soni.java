package satlaa.desijewellery.users_activities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.analytics.FirebaseAnalytics;

import satlaa.desijewellery.R;

public class Manish_Soni extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_manish_soni);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        ImageButton insta = (ImageButton) findViewById(R.id.btn_manish_insta);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/manishsoni2078");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/mr_manish_657664")));
                }
            }
        });

        ImageButton imageButton = (ImageButton) findViewById(R.id.btn_manish_fb);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fi = openFa(Manish_Soni.this);
                startActivity(fi);
            }
        });

        ImageButton imf = (ImageButton) (findViewById(R.id.btn_manish_dialer));
        imf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:+919680398417"));
                startActivity(i);
            }
        });

    }
    public static  Intent openFa(Context context){
        try{
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana",0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/100008206414137"));
        }catch (Exception e ){
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/profile.php?id=100008206414137"));
        }
    }



}

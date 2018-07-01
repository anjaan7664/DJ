package satlaa.desijewellery.UsersActivities;

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

public class Sunil_Soni extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_sunil_soni);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        ImageButton insta = (ImageButton) findViewById(R.id.btn_sunil_insta);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/mr._sunil_soni");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/mr._sunil_soni")));
                }
            }
        });

        ImageButton imageButton = (ImageButton) findViewById(R.id.btn_sunil_fb);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fi = openFa(Sunil_Soni.this);
                startActivity(fi);
            }
        });

        ImageButton imf = (ImageButton) (findViewById(R.id.btn_sunil_dialer));
        imf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:+919587191685"));
                startActivity(i);
            }
        });

    }
    public static  Intent openFa(Context context){
        try{
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana",0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/100005350030677"));
        }catch (Exception e ){
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/profile.php?id=100005350030677"));
        }
    }

}

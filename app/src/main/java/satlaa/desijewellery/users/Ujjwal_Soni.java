package satlaa.desijewellery.users;

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

public class Ujjwal_Soni extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_ujjwal_soni);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        ImageButton insta = (ImageButton) findViewById(R.id.btn_ujju_insta);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/iam_ujjwal_soni");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/iam_ujjwal_soni")));
                }
            }
        });

        ImageButton imageButton = (ImageButton) findViewById(R.id.btn_ujju_fb);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fi = openFa(Ujjwal_Soni.this);
                startActivity(fi);
            }
        });

        ImageButton imf = (ImageButton) (findViewById(R.id.btn_ujju_dialer));
        imf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:+917793055835"));
                startActivity(i);
            }
        });

    }

    public static Intent openFa(Context context) {
        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/100002998477217"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/profile.php?id=100002998477217"));
        }

    }
}

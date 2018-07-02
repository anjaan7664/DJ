package satlaa.desijewellery.users_activities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import satlaa.desijewellery.R;


public class AnjaanSoni extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_anjaan_soni);
        ImageButton insta = (ImageButton) findViewById(R.id.anjaan_insta);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/anjaan2658");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/anjaan2658")));
                }
            }
        });

        ImageButton imageButton = (ImageButton) findViewById(R.id.anjaan_fb);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fi = openF(AnjaanSoni.this);
                startActivity(fi);
            }
        });

        ImageButton imf = (ImageButton) (findViewById(R.id.anjaan_dialer));
        imf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:+918239418128"));
                startActivity(i);
            }
        });

    }
public static  Intent openF(Context context){
    try{
        context.getPackageManager()
                .getPackageInfo("com.facebook.katana",0);
        return new Intent(Intent.ACTION_VIEW,
                Uri.parse("fb://profile/100003215773849"));
    }catch (Exception e ){
        return new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.fb.com/Anjaan7664"));
    }
}}
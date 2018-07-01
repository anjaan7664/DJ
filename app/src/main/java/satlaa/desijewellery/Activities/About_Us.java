package satlaa.desijewellery.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import satlaa.desijewellery.R;
import satlaa.desijewellery.UsersActivities.AnjaanSoni;
import satlaa.desijewellery.UsersActivities.Kailash_Soni;
import satlaa.desijewellery.UsersActivities.Kishor_Soni;
import satlaa.desijewellery.UsersActivities.Ranveer;
import satlaa.desijewellery.UsersActivities.Sunil_Soni;
import satlaa.desijewellery.UsersActivities.Ujjwal_Soni;

public class About_Us extends AppCompatActivity {
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        ImageButton ujju = (ImageButton) findViewById(R.id.btn_ujju);
        ujju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About_Us.this, Ujjwal_Soni.class);
                startActivity(intent);

            }
        });
        ImageButton kailash = (ImageButton) findViewById(R.id.btn_kailash);
        kailash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About_Us.this, Kailash_Soni.class);
                startActivity(intent);

            }
        });
        ImageButton sunil = (ImageButton) findViewById(R.id.btn_sunil);
        sunil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About_Us.this, Sunil_Soni.class);
                startActivity(intent);

            }
        });
        ImageButton kishor = (ImageButton) findViewById(R.id.btn_kishor);
        kishor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About_Us.this, Kishor_Soni.class);
                startActivity(intent);

            }
        });
        ImageButton ranveer = (ImageButton) findViewById(R.id.btn_ranveer);
        kishor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About_Us.this, Ranveer.class);
                startActivity(intent);

            }
        });
        ImageButton anjaan = (ImageButton) findViewById(R.id.btn_anjaan);
        anjaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About_Us.this, AnjaanSoni.class);
                startActivity(intent);

            }
        });


    }
}



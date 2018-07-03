package satlaa.desijewellery.helper_activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import satlaa.desijewellery.R;
import satlaa.desijewellery.activities.MainActivity;
import satlaa.desijewellery.utils.LocaleHelper;

public class Setting extends AppCompatActivity {
    Button privacy, language;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        language = findViewById(R.id.language);
        privacy = findViewById(R.id.priacy);

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this, Webview.class);
                intent.putExtra("link", "https://desijewel.in/privacy.html");
                startActivity(intent);
            }
        });
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(view);
            }
        });

    }

    public void openDialog(View view) {
        final CharSequence[] langOption = {"Hindi", "English"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Langauge");
        builder.setItems(langOption, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String language;
                if (langOption[which] == "Hindi") {

                    language = "hi";
                    LocaleHelper.setLocale(getApplicationContext(), language);

                    Intent intent = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage(getBaseContext().getPackageName());
                    assert intent != null;
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    language = "en";
                    LocaleHelper.setLocale(getApplicationContext(), language);

                    Intent in = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage(getBaseContext().getPackageName());
                    assert in != null;
                    in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(in);
                }
            }
        });


        builder.show();

    }

}

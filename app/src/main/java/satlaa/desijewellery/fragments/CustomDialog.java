package satlaa.desijewellery.fragments;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;

import satlaa.desijewellery.activities.MainActivity;
import satlaa.desijewellery.R;
import satlaa.desijewellery.adapter.RecycleViewAdapter;
import satlaa.desijewellery.utils.Photos;
import satlaa.desijewellery.helper_activity.DJPhotos;


public class CustomDialog extends DialogFragment {
    Button submit;
    EditText fromText, toText;
    String type,weightFrom, weightTo;
    RecycleViewAdapter adapter;
    GridLayout checkBoxLayout;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String url = "http://192.168.43.238/";
    //private static final String url = "https://desijewel.in/";
    private static final String script = url + "android/android_script.php";
    static final String REQ_TAG = "VACTIVITY";
    private ArrayList<Photos> imagelist;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppCompatAlertDialogStyle);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.util_filter, null);
        submit = (Button) view.findViewById(R.id.submit);
        fromText = (EditText) view.findViewById(R.id.fromText);
        toText = (EditText) view.findViewById(R.id.toText);
        checkBoxLayout = (GridLayout) view.findViewById(R.id.checkBoxLayout);
        imagelist = new ArrayList<>();
        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);

        for (int i = 0; i < 3; i++) {
            CheckBox cb = new CheckBox(getActivity());
            cb.setText("Nagina");
            cb.setPadding(20, 10, 10, 10);
            cb.setTextSize(20);
            cb.setTextColor(0xFF25c9bb);
            GridLayout.LayoutParams param = new GridLayout.LayoutParams(GridLayout.spec(
                    GridLayout.UNDEFINED, GridLayout.FILL, 1f),
                    GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f));
            cb.setLayoutParams(param);
            checkBoxLayout.addView(cb);
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String table = ((DJPhotos)getActivity()).getTableValue();
                Intent intent = new Intent(getActivity(), DJPhotos.class);
                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                if(radioButtonID == R.id.newdesign) {
                    type =   "id";
                }
                if(radioButtonID == R.id.topdesign) {
                    type =   "hit";
                }
                intent.putExtra("type", type);
                intent.putExtra("table", table);
                intent.putExtra("weightFrom", fromText.getText().toString());
                intent.putExtra("weightTo", toText.getText().toString());
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}

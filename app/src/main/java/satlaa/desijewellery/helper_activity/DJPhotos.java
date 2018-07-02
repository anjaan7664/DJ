package satlaa.desijewellery.helper_activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import satlaa.desijewellery.adapter.MySingleton;
import satlaa.desijewellery.adapter.RecycleViewAdapter;
import satlaa.desijewellery.fragments.CustomDialog;
import satlaa.desijewellery.fragments.Full_Image;
import satlaa.desijewellery.R;
import satlaa.desijewellery.utils.Photos;


public class DJPhotos extends AppCompatActivity {

    private static final String TAG = DJPhotos.class.getSimpleName();
    private static final String url = "http://192.168.43.238/";
    // private static final String url = "https://desijewel.in/";
    private static final String script = url + "android/android_script.php";
    static final String REQ_TAG = "VACTIVITY";
    public ArrayList<Photos> imagelist;
    // Variable for pagination
    private int pageNumber = 1;
    private boolean isLoading = true;
    private int pastVisibleItems, visibleItemCount, totalItemCount, previousTotal = 0;
    private int viewThesold = 0;
    RecycleViewAdapter adapter;
    String table, type, weightFrom, weightTo;
    Button filterButton;
    RecyclerView recyclerView;
    ProgressBar progressBar, progressBarBottom;

    RecyclerView.LayoutManager mLayoutManager;
    boolean isFirstTime = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_djphotos);
        progressBar = findViewById(R.id.progressBar);
        progressBarBottom = findViewById(R.id.progressBarBottom);
        Intent intent = getIntent();
        table = intent.getStringExtra("table");
        type = intent.getStringExtra("type");
        weightFrom = intent.getStringExtra("weightFrom");
        weightTo = intent.getStringExtra("weightTo");
        imagelist = new ArrayList<>();
        TextView desc = (TextView) findViewById(R.id.desc);
        String descText = "";
        if (type != null) {
            if (type == "hit") {
                descText = descText + "Showing top design.";
            } else {
                descText = descText + ("Showing new design");
            }
        }
        if (weightFrom != null || weightTo != null) {
            descText = descText + ("Weight between " + weightFrom + " to " + weightTo);
        }
        desc.setText(descText);
        ;
        filterButton = findViewById(R.id.filterButton);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(v);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecycleViewAdapter.ClickListener listener = new RecycleViewAdapter.ClickListener() {
            @Override
            public void onClick(int position) {
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                bundle.putSerializable("url", imagelist);//And here i'm always getting the latest image list . u
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Full_Image newFragment = Full_Image.newInstance();
                newFragment.setArguments(bundle);
                newFragment.show(ft, "slideshow");
            }
        };

        adapter = new RecycleViewAdapter(DJPhotos.this, imagelist, listener);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = mLayoutManager.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                pastVisibleItems = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                if (dy > 0) {
                    if (isLoading) {
                        if (totalItemCount > previousTotal) {
                            isLoading = false;
                            previousTotal = totalItemCount;
                        }
                    }
                    if (!isLoading && (totalItemCount - visibleItemCount - 10) <= (pastVisibleItems + viewThesold)) {
                        pageNumber++;
                        performPagination();
                        isLoading = true;
                    }
                }
            }
        });
        getJsonResponsePost();
    }

    public void getJsonResponsePost() {

        progressBar.setVisibility(View.VISIBLE);
        Map<String, String> params = new HashMap();
        params.put("table", table);
        params.put("weightFrom", weightFrom);
        params.put("weightTo", weightTo);
        params.put("type", type);
        HashMap hash = new HashMap();
        hash.put("page", pageNumber);
        params.putAll(hash);
        JSONObject json = new JSONObject(params);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, script, json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        progressBar.setVisibility(View.GONE);
                        imagelist.clear();
                        JSONArray heroArray = null;
                        try {
                            heroArray = response.getJSONArray("images");
                            for (int i = 0; i < heroArray.length(); i++) {
                                JSONObject jsonObject = heroArray.getJSONObject(i);

                                Photos photos = new Photos();
                                photos.setUrl(jsonObject.getString("image"));
                                photos.setThumb(jsonObject.getString("thumb"));
                                photos.setWeight(jsonObject.getString("weight"));
                                photos.setTitle(jsonObject.getString("image_title"));
                                photos.setDate(jsonObject.getString("date"));
                                photos.setHit(jsonObject.getString("hit"));
                                imagelist.add(photos);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter.notifyDataSetChanged();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressBar.setVisibility(View.GONE);
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    Snackbar.make(findViewById(R.id.coordinatorLayout), "Sorry! Not connected to internet", Snackbar.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {

                } else if (error instanceof ServerError) {

                } else if (error instanceof NetworkError) {

                } else if (error instanceof ParseError) {
                }
            }
        });
        jsonObjectRequest.setTag(REQ_TAG);
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getInstance().addToRequestQueue(jsonObjectRequest);

    }

    public String getTableValue() {
        return table;
    }

    public void showDialog(View v) {
        FragmentManager manager = getFragmentManager();
        CustomDialog customDialog = new CustomDialog();

        customDialog.show(manager, "Custom");
    }

    public void performPagination() {

        Map<String, String> params = new HashMap();
        params.put("table", table);
        params.put("weightFrom", weightFrom);
        params.put("weightTo", weightTo);
        params.put("type", type);
        HashMap hash = new HashMap();
        hash.put("page", pageNumber);
        params.putAll(hash);
        JSONObject json = new JSONObject(params);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, script, json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressBarBottom.setVisibility(View.GONE);
                        if(imagelist == null)
                            imagelist = new ArrayList<>();
                        JSONArray heroArray = null;


                        try {
                            heroArray = response.getJSONArray("images");
                            for (int i = 0; i < heroArray.length(); i++) {
                                JSONObject jsonObject = heroArray.getJSONObject(i);

                                Photos photos = new Photos();
                                photos.setUrl(jsonObject.getString("image"));
                                photos.setThumb(jsonObject.getString("thumb"));
                                photos.setWeight(jsonObject.getString("weight"));
                                photos.setTitle(jsonObject.getString("image_title"));
                                photos.setDate(jsonObject.getString("date"));
                                photos.setHit(jsonObject.getString("hit"));
                                imagelist.add(photos);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    Snackbar.make(findViewById(R.id.coordinatorLayout), "Internet is disconnected, Can't load more designs.", Snackbar.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {


                } else if (error instanceof ServerError) {

                } else if (error instanceof NetworkError) {

                } else if (error instanceof ParseError) {
                }
            }
        });
        jsonObjectRequest.setTag(REQ_TAG);
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        if (isFirstTime) {
            RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(getApplicationContext()) {
                @Override
                protected int getVerticalSnapPreference() {
                    return LinearSmoothScroller.SNAP_TO_START;
                }
            };
            smoothScroller.setTargetPosition(0);
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView
                    .getLayoutManager();
            layoutManager.startSmoothScroll(smoothScroller);
            isFirstTime = false;
        } else {
            super.onBackPressed();
        }
    }


}
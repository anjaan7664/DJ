package satlaa.desijewellery.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;

import java.util.ArrayList;
import java.util.List;


import satlaa.desijewellery.R;
import satlaa.desijewellery.Utils.Photos;


public class RecycleViewAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayList<Photos> imagesList = new ArrayList<>();
    private ClickListener mListener;
    private List<Object> mDataset = new ArrayList<>();

    private static final int LIST_AD_DELTA = 3;
    private static final int CONTENT = 0;
    private static final int AD = 1;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ClickListener mListener;
        TextView image_date, image_weight, imageHit;
        ImageView imageView;

        ProgressBar progressBar;

        public MyViewHolder(View view, ClickListener listener) {
            super(view);

            mListener = listener;
            image_date = (TextView) itemView.findViewById(R.id.image_date);
            image_weight = (TextView) itemView.findViewById(R.id.image_weight);
            imageHit = (TextView) itemView.findViewById(R.id.hit);
            imageView = (ImageView) itemView.findViewById(R.id.thumb_image);
            progressBar = itemView.findViewById(R.id.progressBarThumb);
        }


    }
    public static class ViewHolderAdMob extends RecyclerView.ViewHolder {
        public AdView mAdView;
        public ViewHolderAdMob(View view) {
            super(view);
            MobileAds.initialize(view.getContext(),
                    view.getContext().getString(R.string.admob_app_id));

            mAdView = (AdView) view.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();
            mAdView.loadAd(adRequest);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position > 0 && position % LIST_AD_DELTA == 0) {
            return AD;
        }
        return CONTENT;
    }

    public RecycleViewAdapter(Context context, ArrayList<Photos> images, ClickListener listener) {
        mContext = context;
        this.imagesList = images;
        mListener = listener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == CONTENT){
             View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.util_image_thumb, parent, false);
                return new MyViewHolder(itemView, mListener);


        }
        else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_admob, parent, false);

          return new ViewHolderAdMob(v);
        }

    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == CONTENT) {
                Photos image = imagesList.get(position);
                Glide.with(mContext)
                        .load(image.getThumb())
                        .listener(new RequestListener<String, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {


                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                ((MyViewHolder) holder).progressBar.setVisibility(View.GONE);
                                return false;
                            }
                        })
                        .fitCenter()
                        .into(((MyViewHolder) holder).imageView);
                ((MyViewHolder) holder).image_date.setText(image.getTitle());
                ((MyViewHolder) holder).imageHit.setText(image.getHit());
                ((MyViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mListener.onClick(holder.getAdapterPosition());
                    }
                });

                if (!image.getWeight().isEmpty()) {
                    ((MyViewHolder) holder).image_weight.setText(image.getWeight() + " gm");
                }

        }else {

        }
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public interface ClickListener {
        void onClick(int position);

    }

}
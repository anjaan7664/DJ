package satlaa.desijewellery.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;


import satlaa.desijewellery.activities.MainActivity;
import satlaa.desijewellery.R;
import satlaa.desijewellery.utils.Photos;


public class RecycleViewAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ClickListener mListener;
    private final ArrayList<Photos> imagesList;



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ClickListener mListener;
        TextView image_date, image_weight, imageHit;
        ImageView imageView, sudoImage;

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
            MainActivity.loadAd(view);
        }
    }
    public RecycleViewAdapter(Context context, ArrayList<Photos> images, ClickListener listener) {
        mContext = context;
        this.imagesList = images;
        mListener = listener;
    }

    @Override
    public int getItemViewType(int position)
    {
        if (position % 8 == 0)
            return 1;
        return 0;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.util_list_item_admob, parent, false);
                return new ViewHolderAdMob(v);

            default:
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.util_image_thumb, parent, false);

                return new MyViewHolder(itemView, mListener);


        }
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 1:

                break;

            default:
                 final Photos image = imagesList.get(holder.getAdapterPosition());
                 new Handler().post(new Runnable() {
                    @Override
                    public void run() {
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

                    }
                });


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
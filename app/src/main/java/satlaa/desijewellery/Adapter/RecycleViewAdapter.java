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
    private ArrayList<Photos> imagesList;
    private ClickListener mListener;
    // A menu item view type.
    private static final int MENU_ITEM_VIEW_TYPE = 0;

    // The native app install ad view type.
    private static final int NATIVE_APP_INSTALL_AD_VIEW_TYPE = 1;

    // The native content ad view type.
    private static final int NATIVE_CONTENT_AD_VIEW_TYPE = 2;

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

        public static class NativeAppInstallAdViewHolder extends RecyclerView.ViewHolder {
            NativeAppInstallAdViewHolder(View view) {
                super(view);
                NativeAppInstallAdView adView = (NativeAppInstallAdView) view;

                // Register the view used for each individual asset.
                // The MediaView will display a video asset if one is present in the ad, and the
                // first image asset otherwise.
                MediaView mediaView = (MediaView) adView.findViewById(R.id.appinstall_media);
                adView.setMediaView(mediaView);
                adView.setHeadlineView(adView.findViewById(R.id.appinstall_headline));
                adView.setBodyView(adView.findViewById(R.id.appinstall_body));
                adView.setCallToActionView(adView.findViewById(R.id.appinstall_call_to_action));
                adView.setIconView(adView.findViewById(R.id.appinstall_app_icon));
                adView.setPriceView(adView.findViewById(R.id.appinstall_price));
                adView.setStarRatingView(adView.findViewById(R.id.appinstall_stars));
                adView.setStoreView(adView.findViewById(R.id.appinstall_store));
            }
        }

        public static class NativeContentAdViewHolder extends RecyclerView.ViewHolder {
            NativeContentAdViewHolder(View view) {
                super(view);
                NativeContentAdView adView = (NativeContentAdView) view;

                // Register the view used for each individual asset.
                adView.setHeadlineView(adView.findViewById(R.id.contentad_headline));
                adView.setImageView(adView.findViewById(R.id.contentad_image));
                adView.setBodyView(adView.findViewById(R.id.contentad_body));
                adView.setCallToActionView(adView.findViewById(R.id.contentad_call_to_action));
                adView.setLogoView(adView.findViewById(R.id.contentad_logo));
                adView.setAdvertiserView(adView.findViewById(R.id.contentad_advertiser));
            }
        }
    }

    @Override
    public int getItemViewType(int position) {

        Object recyclerViewItem = imagesList.get(position);
        if (recyclerViewItem instanceof NativeAppInstallAd) {
            return NATIVE_APP_INSTALL_AD_VIEW_TYPE;
        } else if (recyclerViewItem instanceof NativeContentAd) {
            return NATIVE_CONTENT_AD_VIEW_TYPE;
        }
        return MENU_ITEM_VIEW_TYPE;
    }
    public RecycleViewAdapter(Context context, ArrayList<Photos> images, ClickListener listener) {
        mContext = context;
        this.imagesList = images;
        mListener = listener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case NATIVE_APP_INSTALL_AD_VIEW_TYPE:
                View nativeAppInstallLayoutView = LayoutInflater.from(
                        parent.getContext()).inflate(R.layout.ad_app_install,
                        parent, false);
                return new MyViewHolder.NativeAppInstallAdViewHolder(nativeAppInstallLayoutView);
            case NATIVE_CONTENT_AD_VIEW_TYPE:
                View nativeContentLayoutView = LayoutInflater.from(
                        parent.getContext()).inflate(R.layout.ad_content,
                        parent, false);
                return new MyViewHolder.NativeContentAdViewHolder(nativeContentLayoutView);
            case MENU_ITEM_VIEW_TYPE:
                // Fall through.
            default:
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.util_image_thumb, parent, false);
                return new MyViewHolder(itemView, mListener);
        }


    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case NATIVE_APP_INSTALL_AD_VIEW_TYPE:
                NativeAppInstallAd appInstallAd = (NativeAppInstallAd) imagesList.get(position);
                populateAppInstallAdView(appInstallAd, (NativeAppInstallAdView) holder.itemView);
                break;
            case NATIVE_CONTENT_AD_VIEW_TYPE:
                NativeContentAd contentAd = (NativeContentAd) imagesList.get(position);
                populateContentAdView(contentAd, (NativeContentAdView) holder.itemView);
                break;
            case MENU_ITEM_VIEW_TYPE:
                // fall through
            default:
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

        }

    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public interface ClickListener {
        void onClick(int position);

    }
    private void populateAppInstallAdView(NativeAppInstallAd nativeAppInstallAd,
                                          NativeAppInstallAdView adView) {

        // Some assets are guaranteed to be in every NativeAppInstallAd.
        ((ImageView) adView.getIconView()).setImageDrawable(nativeAppInstallAd.getIcon()
                .getDrawable());
        ((TextView) adView.getHeadlineView()).setText(nativeAppInstallAd.getHeadline());
        ((TextView) adView.getBodyView()).setText(nativeAppInstallAd.getBody());
        ((Button) adView.getCallToActionView()).setText(nativeAppInstallAd.getCallToAction());

        // These assets aren't guaranteed to be in every NativeAppInstallAd, so it's important to
        // check before trying to display them.
        if (nativeAppInstallAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAppInstallAd.getPrice());
        }

        if (nativeAppInstallAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAppInstallAd.getStore());
        }

        if (nativeAppInstallAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAppInstallAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        // Assign native ad object to the native view.
        adView.setNativeAd(nativeAppInstallAd);
    }
    private void populateContentAdView(NativeContentAd nativeContentAd,
                                       NativeContentAdView adView) {
        // Some assets are guaranteed to be in every NativeContentAd.
        ((TextView) adView.getHeadlineView()).setText(nativeContentAd.getHeadline());
        ((TextView) adView.getBodyView()).setText(nativeContentAd.getBody());
        ((TextView) adView.getCallToActionView()).setText(nativeContentAd.getCallToAction());
        ((TextView) adView.getAdvertiserView()).setText(nativeContentAd.getAdvertiser());

        List<NativeAd.Image> images = nativeContentAd.getImages();

        if (images.size() > 0) {
            ((ImageView) adView.getImageView()).setImageDrawable(images.get(0).getDrawable());
        }

        // Some aren't guaranteed, however, and should be checked.
        NativeAd.Image logoImage = nativeContentAd.getLogo();

        if (logoImage == null) {
            adView.getLogoView().setVisibility(View.INVISIBLE);
        } else {
            ((ImageView) adView.getLogoView()).setImageDrawable(logoImage.getDrawable());
            adView.getLogoView().setVisibility(View.VISIBLE);
        }

        // Assign native ad object to the native view.
        adView.setNativeAd(nativeContentAd);
    }
}
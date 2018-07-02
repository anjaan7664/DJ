package satlaa.desijewellery.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import satlaa.desijewellery.R;
import satlaa.desijewellery.Utils.Photos;


//  adapter
public class MyViewPagerAdapter extends PagerAdapter {
    private Context context;

    ProgressBar fullImagePB;
    private ArrayList<Photos> imagesList = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public MyViewPagerAdapter(Context context, ArrayList<Photos> images) {
        this.context = context;
        this.imagesList = images;

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public Object instantiateItem(final ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Photos image = imagesList.get(position);
        final View view = layoutInflater.inflate(R.layout.util_image_fullscreen_preview, container, false);

        fullImagePB = view.findViewById(R.id.progressBarFull);
        final ImageView imageViewPreview = (ImageView) view.findViewById(R.id.image_preview);
        imageViewPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });


        Glide.with(imageViewPreview.getContext())
                .load(image.getUrl())
                .asBitmap()
                .listener(new RequestListener<String, Bitmap>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .fitCenter().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(final Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

                imageViewPreview.setImageBitmap(resource);
                imageViewPreview.setOnTouchListener(new ImageMatrixTouchHandler(view.getContext()));
            }

        });

    container.addView(view);
        return view;

    }

    @Override
    public int getCount() {
        return imagesList.size();

    }



    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object){
        return PagerAdapter.POSITION_NONE;
    }

}

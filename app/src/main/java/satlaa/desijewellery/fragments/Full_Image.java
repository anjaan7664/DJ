package satlaa.desijewellery.fragments;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bogdwellers.pinchtozoom.view.ImageViewPager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import satlaa.desijewellery.R;
import satlaa.desijewellery.adapter.MyViewPagerAdapter;
import satlaa.desijewellery.utils.Photos;


public class Full_Image extends DialogFragment {
    private String TAG = Full_Image.class.getSimpleName();
    private ArrayList<Photos> images = new ArrayList<>();
    private ImageViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private TextView weight, lblDate;
    private int selectedPosition = 0;
    final File myDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DesiJewellery");
    boolean success = false;
    String img_title, img_weight, fname;
    ArrayList<Bitmap> bitmapArray = new ArrayList<Bitmap>();
    Button save_img, shareImage;
    RelativeLayout rrr;

    public static Full_Image newInstance() {
        Full_Image f = new Full_Image();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_full_image, container, false);
        viewPager = v.findViewById(R.id.viewpager);
        weight = (TextView) v.findViewById(R.id.weight);
        lblDate = (TextView) v.findViewById(R.id.date);
        rrr = v.findViewById(R.id.rrr);
        save_img = (Button) v.findViewById(R.id.save_img);
        shareImage = v.findViewById(R.id.share_img);
        if (getArguments().containsKey("url"))
            images.addAll((ArrayList<Photos>) getArguments().getSerializable("url"));

        selectedPosition = getArguments().getInt("position");
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Design saved in device." + img_title, Toast.LENGTH_SHORT).show();
                rrr.setVisibility(View.GONE);
            }
        });
        final int number = viewPager.getCurrentItem();

        final Photos image = images.get(selectedPosition);
        myViewPagerAdapter = new MyViewPagerAdapter(getActivity().getApplicationContext(), images);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        setCurrentItem(selectedPosition);

        return v;
    }

    private void setCurrentItem(int position) {
        viewPager.setCurrentItem(position, false);
        displayMetaInfo(selectedPosition);
    }

    //  page change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            displayMetaInfo(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void displayMetaInfo(int position) {


        final Photos image = images.get(position);
        lblDate.setText(image.getHit());

        if (!image.getWeight().isEmpty()) {
            weight.setText(image.getWeight() + " gm");
        }
        save_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getActivity())
                        .load(image.getUrl())
                        .asBitmap()
                        .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {

                                saveImage(resource, image.getTitle());
                            }
                        });
            }
        });
        shareImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Glide.with(getActivity())
                        .load(image.getUrl())
                        .asBitmap()
                        .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {

                                shareImage(resource, image.getTitle(), image.getWeight());
                            }
                        });
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }


    public void saveImage(Bitmap bitmap, String img_title) {
        fname = img_title;
        myDir.mkdirs();
        File image = new File(myDir, fname);


        FileOutputStream outStream;
        if (image.exists()) {
            image.delete();
        }
        try {
            outStream = new FileOutputStream(image);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outStream);
            outStream.flush();
            outStream.close();
            success = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (success) {
            Toast.makeText(getActivity(), "Design saved in device." + img_title, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Something went wrong.", Toast.LENGTH_LONG).show();
        }
        // this one to show in gallery:
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            final Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            final Uri contentUri = Uri.fromFile(image);
            scanIntent.setData(contentUri);
            getActivity().sendBroadcast(scanIntent);
        } else {
            getActivity().sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://mnt/sdcard/" + Environment.getExternalStorageDirectory())));
        }
    }

    public void shareImage(Bitmap bitmap, String img_title, String img_weight) {
        fname = img_title;
        myDir.mkdirs();
        File image = new File(myDir, fname);
        FileOutputStream outStream;
        if (!image.exists()) {
            try {
                outStream = new FileOutputStream(image);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outStream);
                outStream.flush();
                outStream.close();
                success = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        final File photoFile = new File(myDir, fname);
        Uri photoURI = FileProvider.getUriForFile(getActivity().getApplicationContext(), getActivity().getApplicationContext().getPackageName() + ".provider", photoFile);
        intent.putExtra(Intent.EXTRA_STREAM, photoURI);

        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra(Intent.EXTRA_TEXT, "Weight - " + img_weight + " GM");
        startActivity(Intent.createChooser(intent, "Share design"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            final Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            final Uri contentUri = Uri.fromFile(image);
            scanIntent.setData(contentUri);
            getActivity().sendBroadcast(scanIntent);
        } else {
            getActivity().sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://mnt/sdcard/" + Environment.getExternalStorageDirectory())));
        }
    }

}
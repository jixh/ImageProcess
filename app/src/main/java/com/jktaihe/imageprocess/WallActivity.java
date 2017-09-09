package com.jktaihe.imageprocess;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.vongihealth.walllibrary.WallAdapter;
import com.vongihealth.walllibrary.WallView;

import static com.vongihealth.walllibrary.WallView.getRandomColor;

/**
 * Created by hzjixiaohui on 2017-9-7.
 */

public class WallActivity extends AppCompatActivity {

    public static final
    String img =  "http://i.meizitu.net/2017/09/08b0";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);

        WallView wallView = findViewById(R.id.wallView);
        wallView.setCellMargin(4);
        wallView.setmWallAdapter(new WallAdapter() {

            @Override
            public int getCount() {
                return 6;
            }

            @Override
            public View getView(Context context, int position) {
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.drawable.ic_launcher);
                imageView.setBackgroundColor(Color.parseColor(getRandomColor(position)));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                Glide
//                        .with(context)
//                        .load(img+(position + 1)+".jpg")
//                        .into(imageView);
                return imageView;
            }
        });
    }
}

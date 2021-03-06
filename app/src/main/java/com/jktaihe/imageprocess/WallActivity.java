package com.jktaihe.imageprocess;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.vongihealth.walllibrary.WallAdapter;
import com.vongihealth.walllibrary.WallView;
/**
 * Created by hzjixiaohui on 2017-9-7.
 */

public class WallActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);

        WallView wallView = findViewById(R.id.wallView);
        wallView.setDevider(4);
        wallView.setmWallAdapter(new WallAdapter() {

            @Override
            public int getCount() {
                return 6;
            }

            @Override
            public View getView(Context context, final int position) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                Glide
                        .with(context)
                        .load("http://pic39.nipic.com/20140312/18085061_092729513131_2.jpg")
                        .into(imageView);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(),"this is click "+position,Toast.LENGTH_SHORT).show();
                    }
                });
                return imageView;
            }
        });



    }
}

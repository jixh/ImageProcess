package com.jktaihe.imageprocess;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

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

        wallView.setmWallAdapter(new WallAdapter() {

            @Override
            public int getCount() {
                return 1;
            }

            @Override
            public View getView(Context context,int position) {
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.drawable.ic_launcher);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });
    }
}

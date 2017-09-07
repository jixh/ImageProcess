package com.vongihealth.walllibrary;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by hzjixiaohui on 2017-9-7.
 */

public class WallView extends LinearLayout {

    private WallAdapter mWallAdapter;

    private int width;// view的高度
    private int height;// view的宽度
    private Model mModel;

    public WallView(Context context) {
        this(context, null);
    }

    public WallView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public WallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                height = getMeasuredHeight();
                width = getMeasuredWidth();
                initView();
                return true;
            }
        });
    }

    private void initView() {

        setOrientation(VERTICAL);

        if (mWallAdapter != null){

            mModel = new Model(mWallAdapter.getCount());

            Cell cell;
            Cell lastCell = null;
            LinearLayout layerLL = null;

            for (int i = 0; i <  mWallAdapter.getCount(); i++) {

                cell = mModel.getCells().get(i);

                 if (getChildAt(cell.getRow() - 1) == null){
                        LinearLayout linearLayout = new LinearLayout(this.getContext());
                        linearLayout.setOrientation(HORIZONTAL);
                        addView(linearLayout,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (cell.getHight()* height)));
                 }

                 if (cell.getLayer() == 1 ){
                     if (lastCell != null && lastCell.getLayer() != 1 ){
                         layerLL = new LinearLayout(this.getContext());
                         layerLL.setOrientation(VERTICAL);
                         ((LinearLayout)getChildAt(cell.getRow() - 1)).addView(layerLL,(int)(cell.getWidth()*width),(int) (lastCell.getHight()* height));
                     }

                     addView(layerLL,cell,i);
                 }else{
                     addView(((LinearLayout)getChildAt(cell.getRow() - 1)),cell,i);
                     if (layerLL != null) layerLL = null;
                 }

                lastCell = cell;
            }
        }
    }


    private void addView(LinearLayout linearLayout,Cell cell,int position){
        linearLayout.addView(mWallAdapter.getView(WallView.this.getContext(),position),(int)(cell.getWidth()*width),(int)(cell.getHight()*height));
    }


    public WallAdapter getmWallAdapter() {
        return mWallAdapter;
    }

    public void setmWallAdapter(WallAdapter mWallAdapter) {
        this.mWallAdapter = mWallAdapter;
    }



}

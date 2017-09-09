package com.vongihealth.walllibrary;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

/**
 * Created by hzjixiaohui on 2017-9-7.
 */

public class WallView extends LinearLayout {

    private WallAdapter mWallAdapter;

    private int width;// view的高度
    private int height;// view的宽度
    private Model mModel;
    private int cellMargin;
    private boolean isDraw = false;
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
                if (!isDraw){
                    height = getMeasuredHeight();
                    width = getMeasuredWidth();

                    initView();
                    isDraw = true;
                }

                return true;
            }
        });
    }


    private void initView() {

        Log.i("WallView","initView");

        width = height = Math.min(width,height);

//        setPadding(cellMargin,cellMargin,cellMargin,cellMargin);

        setOrientation(VERTICAL);

        if (mWallAdapter != null){

            mModel = new Model(mWallAdapter.getCount(),width,cellMargin);

            Cell cell;
            Cell lastCell = null;
            LinearLayout layerLL = null;

            for (int i = 0; i <  mWallAdapter.getCount(); i++) {

                cell = mModel.getCells().get(i);

                LinearLayout firstLayer = (LinearLayout) getChildAt(cell.getRow() - 1);

                if (firstLayer == null) {
                    firstLayer = new LinearLayout(this.getContext());
                    firstLayer.setGravity(Gravity.CENTER_VERTICAL);
                    firstLayer.setOrientation(HORIZONTAL);
                    addView(firstLayer, new LayoutParams(width, (int) (cell.getHight() + 2* cellMargin)));
                }

                 if (cell.getLayer() == 1 ){
                     if (lastCell != null && lastCell.getLayer() != 1 ){
                         layerLL = new LinearLayout(this.getContext());
                         layerLL.setOrientation(VERTICAL);
//                         firstLayer.setGravity(Gravity.CENTER_HORIZONTAL);
                         firstLayer.addView(layerLL,new LayoutParams((int)(cell.getWidth()+2*cellMargin),  (int)(lastCell.getHight()+2*cellMargin)));
                     }
                     addView(layerLL,cell,i);
                 }else{
                     addView(firstLayer,cell,i);
                     if (layerLL != null) layerLL = null;
                 }

                lastCell = cell;
            }
        }
    }


    private void addView(LinearLayout linearLayout,Cell cell,int position){
        LinearLayout.LayoutParams layoutParams = new LayoutParams((int)cell.getWidth(),(int)cell.getHight());
        layoutParams.setMargins(cellMargin,cellMargin,cellMargin,cellMargin);
        layoutParams.gravity = Gravity.CENTER;
        linearLayout.addView(mWallAdapter.getView(linearLayout.getContext(),position),layoutParams);
    }


    public WallAdapter getmWallAdapter() {
        return mWallAdapter;
    }

    public void setmWallAdapter(WallAdapter mWallAdapter) {
        this.mWallAdapter = mWallAdapter;
    }


    public void setCellMargin(int cellMargin) {
        this.cellMargin = cellMargin;
    }


    public static String getRandomColor(int i){
        return "#"+ i+ (9-i)+ 0 + i+ (9-i)+i;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}

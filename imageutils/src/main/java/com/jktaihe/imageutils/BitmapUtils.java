package com.jktaihe.imageutils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * @author hzjixiaohui
 * @Desc
 * @date 2017-2-27
 */

public class BitmapUtils {

    /**
     *
     * @param bmp
     * @param colorArray
     * @return
     */
    public static Bitmap processImage(Bitmap bmp, float[] colorArray){
        if(bmp!=null&&colorArray!=null){
            int width, height;
            height = bmp.getHeight();
            width = bmp.getWidth();
            Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Paint myPaint = new Paint();
            Canvas canvas=new Canvas(bm);
            ColorMatrix myColorMatrix = new ColorMatrix();
            myColorMatrix.set(colorArray);
            myPaint.setColorFilter(new ColorMatrixColorFilter(myColorMatrix));
            canvas.drawBitmap(bmp,0,0,myPaint);
            return bm;
        }else{
            return bmp;
        }

    }


    public static Bitmap processImage(Bitmap bitmap,int color){

        float[] colorArray = {
                Color.red(color), 0,                  0,                 0, 0,
                0,                Color.green(color), 0,                 0, 0,
                0,                0,                  Color.blue(color), 0, 0,
                0,                0,                  0,                 Color.alpha(color), 0
        };

        return processImage(bitmap,colorArray);
    }


    public static Bitmap getAlphaBitmap(Bitmap mBitmap,int mColor) {
//          BitmapDrawable mBitmapDrawable = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.enemy_infantry_ninja);
//          Bitmap mBitmap = mBitmapDrawable.getBitmap();

        //BitmapDrawable的getIntrinsicWidth（）方法，Bitmap的getWidth（）方法
        //注意这两个方法的区别
        //Bitmap mAlphaBitmap = Bitmap.createBitmap(mBitmapDrawable.getIntrinsicWidth(), mBitmapDrawable.getIntrinsicHeight(), Config.ARGB_8888);
        Bitmap mAlphaBitmap = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas mCanvas = new Canvas(mAlphaBitmap);
        Paint mPaint = new Paint();
        mPaint.setColor(mColor);
        //从原位图中提取只包含alpha的位图
        Bitmap alphaBitmap = mBitmap.extractAlpha();
        //在画布上（mAlphaBitmap）绘制alpha位图
        mCanvas.drawBitmap(alphaBitmap, 0, 0, mPaint);

        return mAlphaBitmap;
    }

}

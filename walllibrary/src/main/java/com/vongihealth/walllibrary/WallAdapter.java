package com.vongihealth.walllibrary;

import android.content.Context;
import android.view.View;

/**
 * Created by hzjixiaohui on 2017-9-7.
 */

public interface WallAdapter {
    int getCount();
    View getView(Context context,int position);
}

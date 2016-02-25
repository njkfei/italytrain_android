/*
 * Copyright (c) 2014, 青岛司通科技有限公司 All rights reserved.
 * File Name：ShowToast.java
 * Version：V1.0
 * Author：zhaokaiqiang
 * Date：2014-8-7
 */
package niejinkun.com.italytrain.utils;

import android.support.annotation.NonNull;
import android.widget.Toast;

import niejinkun.com.italytrain.base.Application;

public class ShowToast {

    public static void Short(@NonNull CharSequence sequence) {
        Toast.makeText(Application.getContext(), sequence, Toast.LENGTH_SHORT).show();
    }

    public static void Long(@NonNull CharSequence sequence) {
        Toast.makeText(Application.getContext(), sequence, Toast.LENGTH_SHORT).show();
    }

}

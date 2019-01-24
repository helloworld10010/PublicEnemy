package com.dnf.jarvis.publicenemy.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;
import com.dnf.jarvis.publicenemy.DevMvpApplication;

/**
 * Created by Liang_Lu on 2017/9/7.
 */

public class ToastUtils {

    private static Toast toast;

    public static void show(CharSequence text) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(DevMvpApplication.getAppContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }
}

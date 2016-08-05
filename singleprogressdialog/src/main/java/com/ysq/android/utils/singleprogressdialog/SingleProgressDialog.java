package com.ysq.android.utils.singleprogressdialog;

import android.app.Activity;
import android.app.ProgressDialog;

import java.lang.ref.WeakReference;

public class SingleProgressDialog {

    private ProgressDialog mProgressDialog;
    final WeakReference<Activity> mContext;
    private static SingleProgressDialog mSelf;

    private SingleProgressDialog(Activity context) {
        mContext = new WeakReference<Activity>(context);
    }

    public static synchronized SingleProgressDialog getInstance(Activity context) {
        if (mSelf == null) {
            mSelf = new SingleProgressDialog(context);
        } else if (mSelf.mContext.get() != context) {
            mSelf.dismiss();
            mSelf = new SingleProgressDialog(context);
        }
        return mSelf;
    }

    public void show(String title, CharSequence content) {
        dismiss();
        if (mContext.get() != null) {
            mProgressDialog = ProgressDialog.show(mContext.get(), title, content, true);
        }
    }

    public void show() {
        show(null, null);
    }

    public void dismiss() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
            mProgressDialog = null;
        }
    }
}

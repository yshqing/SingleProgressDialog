package com.ysq.android.utils.singleprogressdialog;

import android.app.Activity;

import java.lang.ref.WeakReference;

public class SingleProgressDialog {

    private XProgressDialog mProgressDialog;
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

    public void show(String content) {
        dismiss();
        if (mContext.get() != null) {
            mProgressDialog = new XProgressDialog(mContext.get(), content);
            mProgressDialog.show();
        }
    }

    public void show() {
        show(null);
    }

    public void dismiss() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
            mProgressDialog = null;
        }
    }

    public void setMessageText(String messageText) {
        if (mProgressDialog != null) {
            mProgressDialog.setMessageText(messageText);
        }
    }
}

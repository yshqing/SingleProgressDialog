package com.ysq.android.utils.singleprogressdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by ysq on 16/9/23.
 */
public class XProgressDialog extends AlertDialog {
    protected String messageText = "";

    public XProgressDialog(Context context) {
        super(context);
    }

    public XProgressDialog(Context context, String message) {
        super(context);
        this.messageText = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_xprogressdialog_circle_progress);
        TextView tvMessage = (TextView) findViewById(R.id.message);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        if (tvMessage != null) {
            if (!TextUtils.isEmpty(messageText)) {
                tvMessage.setText(messageText);
            } else {
                tvMessage.setVisibility(View.GONE);
            }
        }
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
}

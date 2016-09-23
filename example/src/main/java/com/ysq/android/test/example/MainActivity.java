package com.ysq.android.test.example;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ysq.android.utils.singleprogressdialog.SingleProgressDialog;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            SingleProgressDialog.getInstance(MainActivity.this).dismiss();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btn_show);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleProgressDialog.getInstance(MainActivity.this).show("加载中...");
                mHandler.sendEmptyMessageDelayed(0, 1000*5);
            }
        });
    }
}

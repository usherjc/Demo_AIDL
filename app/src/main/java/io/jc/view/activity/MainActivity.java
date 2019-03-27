package io.jc.view.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import io.jc.R;
import io.jc.service.Test01Service;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnTest1Open, mBtnTest1Close, mBtnTest2Open, mBtnTest2Close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //////////////////////////////////////////////////////////// init views
        mBtnTest1Open = findViewById(R.id.btn_test_1_open);
        mBtnTest1Close = findViewById(R.id.btn_test_1_close);
        mBtnTest2Open = findViewById(R.id.btn_test_2_open);
        mBtnTest2Close = findViewById(R.id.btn_test_2_close);
        //////////////////////////////////////////////////////////// init actions
        mBtnTest1Open.setOnClickListener(this);
        mBtnTest1Close.setOnClickListener(this);
        mBtnTest2Open.setOnClickListener(this);
        mBtnTest2Close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.btn_test_1_open:
                i = new Intent(this, Test01Service.class);
                startService(i);
                break;
            case R.id.btn_test_1_close:
                i = new Intent(this, Test01Service.class);
                stopService(i);
                break;
            case R.id.btn_test_2_open:
                i = new Intent(this, Test01Service.class);
                bindService(i, mConnection, BIND_AUTO_CREATE);
                break;
            case R.id.btn_test_2_close:
                unbindService(mConnection);
                break;
        }
    }

    private Test01Service.Test01Binder mBinder;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinder = (Test01Service.Test01Binder) service;
            mBinder.obtainStr();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            unbindService(mConnection);
        }
    };

}

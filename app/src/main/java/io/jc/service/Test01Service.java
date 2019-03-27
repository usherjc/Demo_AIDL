package io.jc.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @name : usherchen
 * @date : 2019/3/21
 * @item : midea fridge
 * @desc : Test01Service
 */
public class Test01Service extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("usherchen_", "Test01Service onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("usherchen_", "Test01Service onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("usherchen_", "Test01Service onDestroy: ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("usherchen_", "Test01Service onBind: ");
        return new Test01Binder();
    }

    public class Test01Binder extends Binder {
        public void obtainStr() {
            Log.i("usherchen_", "Test01Service Test01Binder obtainStr: ");
        }
    }

}

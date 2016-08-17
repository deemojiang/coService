package com.deemo.coservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by deemojiang on 2016/5/23.
 *
 */
public class SelfStartService extends Service {

    private Binder mBinder = new Binder();

    public class Binder extends android.os.Binder
    {
        public SelfStartService getService()
        {
            return SelfStartService.this;
        }
    }

    public SelfStartService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(getApplicationContext(), SelfStartService.class);
        startService(intent);
    }
}

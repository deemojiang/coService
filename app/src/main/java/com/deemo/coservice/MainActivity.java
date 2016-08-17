package com.deemo.coservice;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private  GeayKeepReceiver receiver = new GeayKeepReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        NotificationManager manager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        Notification notification =new Notification.Builder(this).setSmallIcon(R.mipmap.ic_launcher).build();
//        RemoteViews contentView = new RemoteViews(getPackageName(),R.layout.notify);
//        notification.contentView =contentView;
//        manager.notify(22,notification);


        final Intent intent = new Intent(getApplicationContext(), SelfStartService.class);
        startService(intent);

        final Intent intent1 = new Intent(getApplicationContext(), GrayService.class);
        startService(intent1);

        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(receiver,filter);


        findViewById(R.id.stopSelf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });

        findViewById(R.id.stopGray).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent1);

            }
        });
    }



}

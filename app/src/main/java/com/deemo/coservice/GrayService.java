package com.deemo.coservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.widget.RemoteViews;

/**
 * Created by deemojiang on 2016/5/23.
 *
 */
public class GrayService extends Service {

    private final static int GRAY_SERVICE_ID = 1001;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//////        Notification notification =new Notification();
//        RemoteViews contentView = new RemoteViews(getPackageName(),R.layout.notify);
//////        notification.contentView = contentView;
//////        Notification notification = new NotificationCompat.Builder(this).setContent(contentView).build();
//        Notification notification =new Notification.Builder(this).setSmallIcon(R.mipmap.ic_launcher).build();
//        notification.contentView = contentView;
////        startForeground(GRAY_SERVICE_ID, notification);
//        NotificationManager manager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);



        if (Build.VERSION.SDK_INT < 18) {
            startForeground(GRAY_SERVICE_ID,  new Notification());//API < 18 ，此方法能有效隐藏Notification上的图标
        } else {
            startForeground(GRAY_SERVICE_ID, new Notification());
            Intent innerIntent = new Intent(this, GrayInnerService.class);
            startService(innerIntent);
           // manager.cancel(GRAY_SERVICE_ID);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}

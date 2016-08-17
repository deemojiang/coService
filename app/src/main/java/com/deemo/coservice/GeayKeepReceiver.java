package com.deemo.coservice;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by deemojiang on 2016/5/26.
 */
public class GeayKeepReceiver extends BroadcastReceiver {

    public GeayKeepReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_TIME_TICK)) {
            int i =0 ;
            Log.v("GeayKeepReceiver","onReceive" + (i++));
            boolean isGrayWork = isServiceWorked(context, "com.deemo.coservice.GrayService");
            if (!isGrayWork){
                Log.v("GeayKeepReceiver","isGrayWork" + i);
                final Intent intent1 = new Intent(context, GrayService.class);
                context.startService(intent1);
            }
        }

    }

    public static boolean isServiceWorked(Context context, String serviceName) {
        ActivityManager myManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ArrayList<ActivityManager.RunningServiceInfo> runningService = (ArrayList<ActivityManager.RunningServiceInfo>) myManager.getRunningServices(Integer.MAX_VALUE);
        for (int i = 0; i < runningService.size(); i++) {
            if (runningService.get(i).service.getClassName().toString().equals(serviceName)) {
                return true;
            }
        }
        return false;
    }


}

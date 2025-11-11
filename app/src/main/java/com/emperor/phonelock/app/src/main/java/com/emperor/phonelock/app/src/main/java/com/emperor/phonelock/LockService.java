package com.emperor.phonelock;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LockService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }
}

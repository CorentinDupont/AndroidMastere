package com.example.mastereapp.Services;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MonService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        return super.onStartCommand(intent, flags, startId);
    }
    // Binder :
    private IBinder binder = new MonBinder();
    // Classe MonBinder :
    public class MonBinder extends Binder
    {
        public MonService getService() { return MonService.this; }
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public int incrementCounter(int counter) {
        return counter++;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}

package com.example.mastereapp.Services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MonIntentService extends IntentService {
    // Constructeur obligatoire :
    public MonIntentService() {
        super("MonIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("MonIntentService", "Start updating counter ...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer newCounterValue = intent.getIntExtra("counter", 0) + 1;
        Log.i("MonIntentService", "compteur = " + newCounterValue);
    }
}
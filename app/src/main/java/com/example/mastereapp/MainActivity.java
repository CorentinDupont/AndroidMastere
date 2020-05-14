package com.example.mastereapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onCreate: ");
        }

        Context context = getApplicationContext();
        Toast.makeText(context, "Bienvenue !", Toast.LENGTH_SHORT);

        // Find buttons
        Button helloWorldButton = this.findViewById(R.id.hello_world_button);
        Button readerButton = this.findViewById(R.id.reader_button);
        Button savedCounterButton = this.findViewById(R.id.saved_counter_button);
        Button timerButton = this.findViewById(R.id.timer_button);
        Button memoButton = this.findViewById(R.id.memo_text_et);
        Button paintButton = this.findViewById(R.id.paint_button);
        Button bitmapButton = this.findViewById(R.id.bitmap_button);
        Button contactButton = this.findViewById(R.id.contact_button);
        Button notificationButton = this.findViewById(R.id.notification_button);
        Button asyncButton = this.findViewById(R.id.async_button);
        Button serviceButton = this.findViewById(R.id.service_button);

        // Add on click listeners
        helloWorldButton.setOnClickListener(this);
        readerButton.setOnClickListener(this);
        savedCounterButton.setOnClickListener(this);
        timerButton.setOnClickListener(this);
        memoButton.setOnClickListener(this);
        paintButton.setOnClickListener(this);
        bitmapButton.setOnClickListener(this);
        contactButton.setOnClickListener(this);
        notificationButton.setOnClickListener(this);
        asyncButton.setOnClickListener(this);
        serviceButton.setOnClickListener(this);
    }

    /**
     * Permit to use this to add on click listeners.
     * This onCLick override intercept all click of the buttons on
     * this page.
     * @param v clicked button
     */
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.hello_world_button:
                intent = new Intent(this, HelloWorldActivity.class);
                break;
            case R.id.reader_button:
                intent = new Intent(this, ReaderActivity.class);
                break;
            case R.id.saved_counter_button:
                intent = new Intent(this, SavedCounterActivity.class);
                break;
            case R.id.timer_button:
                intent = new Intent(this, Timer1Activity.class);
                break;
            case R.id.memo_text_et:
                intent = new Intent(this, MemoActivity.class);
                break;
            case R.id.paint_button:
                intent = new Intent(this, PaintingActivity.class);
                break;
            case R.id.bitmap_button:
                intent = new Intent(this, BitmapActivity.class);
                break;
            case R.id.contact_button:
                intent = new Intent(this, ContactActivity.class);
                break;
            case R.id.notification_button:
                intent = new Intent(this, NotificationActivity.class);
                break;
            case R.id.async_button:
                intent = new Intent(this, AsyncActivity.class);
                break;
            case R.id.service_button:
                intent = new Intent(this, Service1Activity.class);
                break;
            default:
                Context context = getApplicationContext();
                Toast.makeText(context, "Aucune activité n'est liée à ce bouton.", Toast.LENGTH_SHORT);
        }

        if (intent != null) {
            startActivity(intent);
        };
    }
}

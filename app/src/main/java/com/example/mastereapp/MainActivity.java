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

        // Add on click listeners
        helloWorldButton.setOnClickListener(this);
        readerButton.setOnClickListener(this);
        savedCounterButton.setOnClickListener(this);
        timerButton.setOnClickListener(this);
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
            default:
                Context context = getApplicationContext();
                Toast.makeText(context, "Aucune activité n'est lié à ce bouton.", Toast.LENGTH_SHORT);
        }

        if (intent != null) {
            startActivity(intent);
        };
    }
}

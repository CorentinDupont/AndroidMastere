package com.example.mastereapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SavedCounterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView counterTV;
    private int counter;
    private static String COUNTER_KEY = "counter";

    private static String DE_1_KEY = "de1";
    private static String DE_2_KEY = "de2";
    private static String DE_3_KEY = "de3";

    private int de1Value;
    private int de2Value;
    private int de3Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_counter);

        // find de text views
        TextView de1TV = this.findViewById(R.id.de1);
        TextView de2TV = this.findViewById(R.id.de2);
        TextView de3TV = this.findViewById(R.id.de3);

        if (savedInstanceState != null) {
            // get saved value
            counter = savedInstanceState.getInt(COUNTER_KEY);
            de1Value = savedInstanceState.getInt(DE_1_KEY);
            de2Value = savedInstanceState.getInt(DE_2_KEY);
            de3Value = savedInstanceState.getInt(DE_3_KEY);
        } else {
            // initialize
            counter = 0;
            setDeValues();
        }

        // set de text
        de1TV.setText(String.valueOf(de1Value));
        de2TV.setText(String.valueOf(de2Value));
        de3TV.setText(String.valueOf(de3Value));

        // Set counter value into text view
        counterTV = this.findViewById(R.id.counter_tv);
        counterTV.setText(String.valueOf(counter));

        Button incrementButton = this.findViewById(R.id.increment_button);
        incrementButton.setOnClickListener(this);

    }

    private void setDeValues() {
        Random r = new Random();
        de1Value = r.nextInt((6 - 1) + 1) + 1;
        de2Value = r.nextInt((6 - 1) + 1) + 1;
        de3Value = r.nextInt((6 - 1) + 1) + 1;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(COUNTER_KEY, counter);
        outState.putInt(DE_1_KEY, de1Value);
        outState.putInt(DE_2_KEY, de2Value);
        outState.putInt(DE_3_KEY, de3Value);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.increment_button) {
            counter++;
            counterTV.setText(String.valueOf(counter));
        }
    }
}

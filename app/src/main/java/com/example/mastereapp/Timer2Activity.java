package com.example.mastereapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Timer2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer2);

        Button startButton = this.findViewById(R.id.start_timer_button);
        startButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start_timer_button) {
            EditText timerET = this.findViewById(R.id.timer_et);

            Intent intent = new Intent(this, Timer1Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            intent.putExtra("timer", Integer.parseInt(timerET.getText().toString()) * 1000);
            setResult(1, intent);
            finish();
        }
    }
}

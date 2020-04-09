package com.example.mastereapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.service.autofill.TextValueSanitizer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Timer1Activity extends AppCompatActivity implements View.OnClickListener {

    TextView createTimerTV;
    String initialText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer1);

        createTimerTV = this.findViewById(R.id.create_timer_tv);
        initialText = createTimerTV.getText().toString();
        createTimerTV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.create_timer_tv) {
            Intent intent = new Intent(this, Timer2Activity.class);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            Integer time = data.getIntExtra("timer", 0);

            if (time != 0) {
                launchCountDownTimer(time);
            }
        }
    }

    private void launchCountDownTimer(int ms) {
        new CountDownTimer(ms, 1000) {

            public void onTick(long millisUntilFinished) {
                createTimerTV.setText("seconds remaining: " + (millisUntilFinished / 1000 + 1));
            }

            public void onFinish() {
                createTimerTV.setText(initialText);
            }

        }.start();
    }
}

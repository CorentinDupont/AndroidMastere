package com.example.mastereapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mastereapp.Services.MonIntentService;

public class Service1Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service1);

        Button button = findViewById(R.id.start_intent_service_button);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_intent_service_button: {
                Intent intent = new Intent(this, MonIntentService.class);
                intent.putExtra("counter", 0);
                startService(intent);
            }
        }
    }
}

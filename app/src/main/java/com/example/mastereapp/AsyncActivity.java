package com.example.mastereapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mastereapp.Async.PrimeNumberAsyncTask;

public class AsyncActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        Button button = findViewById(R.id.async_calcul_button);
        button.setOnClickListener(this);

        resultTV = findViewById(R.id.async_result_tv);

    }

    public void displayResult(boolean isPrimeNumber) {
        resultTV.setText("Nombre premier ? : " + isPrimeNumber);
    }

    public void setCalculProgress(int percentValue) {
        ProgressBar progressBar = findViewById(R.id.async_progress_bar);
        progressBar.setProgress(percentValue);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.async_calcul_button) {
            resultTV.setText("Calculating ...");

            EditText numberET = findViewById(R.id.async_number_et);
            Double number = Double.parseDouble(numberET.getText().toString());

            PrimeNumberAsyncTask asyncTask = new PrimeNumberAsyncTask(this);
            asyncTask.execute(number);
        }
    }


}

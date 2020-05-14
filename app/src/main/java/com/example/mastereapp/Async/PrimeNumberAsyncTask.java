package com.example.mastereapp.Async;

import android.os.AsyncTask;
import com.example.mastereapp.AsyncActivity;
import java.lang.ref.WeakReference;

public class PrimeNumberAsyncTask extends AsyncTask<Double, Double, Boolean> {

    private WeakReference<AsyncActivity> weakAsyncActivity;

    public PrimeNumberAsyncTask(AsyncActivity activity) {
        weakAsyncActivity = new WeakReference<>(activity);
    }

    @Override
    protected Boolean doInBackground(Double... doubles) {

        Double n = doubles[0];
        boolean isPremier = true;

        if (n < 0) { isPremier = false; }
        else if (n != 0 && n != 1) {
            for (int i = 2; i <= n / 2; i++) {
                if (n != i && n % i == 0) {
                    isPremier = false;
                    break;
                }

                publishProgress(n, (double) i);
            }
        }

        publishProgress(n, n);
        return isPremier;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        weakAsyncActivity.get().displayResult(result);
    }

    @Override
    protected void onProgressUpdate(Double... values) {
        weakAsyncActivity.get().setCalculProgress((int) (values[1] * 100 / values[0]));
    }
}

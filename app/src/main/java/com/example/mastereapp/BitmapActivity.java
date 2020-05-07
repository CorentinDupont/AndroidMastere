package com.example.mastereapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BitmapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        ImageView imageView = findViewById(R.id.picasso_iv);
        Picasso.with(this)
                .load("https://journalduluxe.fr/wp-content/uploads/2018/02/plus-belle-plage-du-monde-800x600.jpeg")
                .fit()
                .centerInside()
                .into(imageView);

    }
}

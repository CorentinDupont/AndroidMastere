package com.example.mastereapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

public class ReaderActivity extends AppCompatActivity implements View.OnClickListener {

    ScrollView articleScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        setTitle("Lorem Ipsum");

        Button goToTopButton = this.findViewById(R.id.go_to_top_button);
        goToTopButton.setOnClickListener(this);
        articleScrollView = this.findViewById(R.id.article_scroll_view);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.go_to_top_button) {
            articleScrollView.fullScroll(ScrollView.FOCUS_UP);
            Context context = getApplicationContext();
            Toast.makeText(context, "Vous êtes revenu au début de l'article !", Toast.LENGTH_SHORT);
        }
    }
}

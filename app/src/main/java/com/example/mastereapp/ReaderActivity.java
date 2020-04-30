package com.example.mastereapp;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.mastereapp.Adapters.ReaderPageAdapter;

import java.io.Reader;
import java.util.ArrayList;

public class ReaderActivity extends AppCompatActivity implements View.OnClickListener {

    ScrollView articleScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        setTitle("Lorem Ipsum");

        Button goToTopButton = this.findViewById(R.id.go_to_top_button);
        goToTopButton.setOnClickListener(this);

        ArrayList<String> texts = new ArrayList<>();
        texts.add("Je suis le texte de la première page.");
        texts.add("Voici le texte de la deuxième page");
        texts.add("Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable." +
                "Et par magie, nous voici sur la dernière page de ce bouquin. 100 balles. Rentable.");

        ReaderPageAdapter adapter = new ReaderPageAdapter(getSupportFragmentManager(), texts);
        ViewPager viewPager = findViewById(R.id.reader_view_pager);
        viewPager.setAdapter(adapter);
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

package com.example.mastereapp.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mastereapp.R;
import com.example.mastereapp.ReaderPageDialogFragment;
import com.example.mastereapp.ReaderPageFragment;

import java.util.ArrayList;

public class ReaderPageAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> texts;

    // Constructeur
    public ReaderPageAdapter(FragmentManager fragmentManager, ArrayList<String> texts)
    {
        super(fragmentManager);
        this.texts = texts;
    }

    @Override
    public Fragment getItem(int i) {
        // create fragment
        ReaderPageFragment fragment = new ReaderPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ReaderPageFragment.ARG_PAGE_TEXT, texts.get(i));
        bundle.putInt(ReaderPageFragment.ARG_PAGE_NUMBER, i);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return texts.size();
    }
}

package com.example.mastereapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReaderPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReaderPageFragment extends Fragment implements View.OnClickListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PAGE_TEXT = "page_text";
    public static final String ARG_PAGE_NUMBER = "page_number";

    private String pageText;
    private Integer pageNumber;


    public ReaderPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param pageText The text string to display in the fragment
     * @param pageNumber The page number to display it in dialog
     * @return A new instance of fragment ReaderPageFragment.
     */
    public static ReaderPageFragment newInstance(String pageText, Integer pageNumber) {
        ReaderPageFragment fragment = new ReaderPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PAGE_TEXT, pageText);
        args.putInt(ARG_PAGE_NUMBER, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pageText = getArguments().getString(ARG_PAGE_TEXT);
            pageNumber = getArguments().getInt(ARG_PAGE_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reader_page, container, false);
        TextView textView = view.findViewById(R.id.page_text_tv);
        textView.setText(pageText);
        textView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.page_text_tv) {
            ReaderPageDialogFragment dialogFragment = new ReaderPageDialogFragment();
            Bundle args = new Bundle();
            args.putInt(ReaderPageDialogFragment.PAGE_NUMBER_PARAM, pageNumber);
            args.putInt(ReaderPageDialogFragment.WORDS_COUNT_PARAM, pageText.split(" ").length);
            dialogFragment.setArguments(args);
            dialogFragment.show(getActivity().getSupportFragmentManager(), "ReaderDialogFragment");

        }
    }
}

package com.example.mastereapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ReaderPageDialogFragment extends DialogFragment {

    public static String PAGE_NUMBER_PARAM = "page_number_param";
    public static String WORDS_COUNT_PARAM = "words_count_param";

    Integer pageNumber;
    Integer wordsCount;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        if(getArguments() != null) {
            pageNumber = getArguments().getInt(PAGE_NUMBER_PARAM, 0);
            wordsCount = getArguments().getInt(WORDS_COUNT_PARAM, 0);
        }

        // paramétrage de la boîte de dialogue grâce à un builder :
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // inflater :
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_fragment_reader, null);

        TextView pageNumberTV = view.findViewById(R.id.page_number_tv);
        TextView wordsCountTV = view.findViewById(R.id.word_number_tv);

        pageNumberTV.setText("Page n° " + pageNumber);
        wordsCountTV.setText("Nombre de mots : " + wordsCount);

        builder
            .setView(view)
            .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id)
                {
                    dismiss();
                }
            });


        // création de la boîte de dialogue:

        return builder.create();
    }
}

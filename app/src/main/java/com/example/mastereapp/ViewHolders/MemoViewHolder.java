package com.example.mastereapp.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mastereapp.R;

public class MemoViewHolder extends RecyclerView.ViewHolder {

    private TextView memoTextTV = null;

    public MemoViewHolder(@NonNull View itemView) {
        super(itemView);
        this.memoTextTV = itemView.findViewById(R.id.memo_text_tv);
    }

    public TextView getMemoTextTV() {
        return memoTextTV;
    }
}

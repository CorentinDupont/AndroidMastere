package com.example.mastereapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mastereapp.Entities.Memo;
import com.example.mastereapp.R;

import java.util.List;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.MemoViewHolder> {

    private List<Memo> listMemo = null;

    public MemoAdapter(List<Memo> listMemo) {
        this.listMemo = listMemo;
    }

    @NonNull
    @Override
    public MemoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewMemo = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_memo, viewGroup, false);
        return new MemoViewHolder(viewMemo);
    }

    @Override
    public void onBindViewHolder(@NonNull MemoViewHolder memoViewHolder, int i) {
        memoViewHolder.getMemoTextTV().setText(listMemo.get(i).getText());
    }

    @Override
    public int getItemCount() {
        return listMemo.size();
    }

    class MemoViewHolder extends RecyclerView.ViewHolder {

        private TextView memoTextTV = null;

        private MemoViewHolder(@NonNull View itemView) {
            super(itemView);

            this.memoTextTV = itemView.findViewById(R.id.memo_text_tv);

            // add on click listener to show position and content of the memo.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Memo memo = listMemo.get(getAdapterPosition());
                    Toast.makeText(v.getContext(), memo.getText() + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        private TextView getMemoTextTV() {
            return memoTextTV;
        }

    }
}



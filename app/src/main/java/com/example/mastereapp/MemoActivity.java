package com.example.mastereapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mastereapp.Adapters.MemoAdapter;
import com.example.mastereapp.Entities.Memo;

import java.util.ArrayList;
import java.util.List;

public class MemoActivity extends AppCompatActivity implements View.OnClickListener {

    // memo list
    List<Memo> listMemo = new ArrayList<>();

    // memo list adapter
    MemoAdapter memoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        // get recycler view
        RecyclerView recyclerView = findViewById(R.id.memo_rv);
        recyclerView.setHasFixedSize(true);

        // item disposition
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

        // create fake memo list
        listMemo = buildFakeMemoList(10);

        // create and set recycler view adapter
        memoAdapter = new MemoAdapter(listMemo);
        recyclerView.setAdapter(memoAdapter);

        // handle adding memos
        Button addMemoButton = findViewById(R.id.memo_ok_button);
        addMemoButton.setOnClickListener(this);

    }

    /**
     * Build a list of memo with fake data taking a length
     * @param length length of the generated list
     * @return a fake memo list
     */
    private List<Memo> buildFakeMemoList(int length) {
        List<Memo> listMemo = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listMemo.add(new Memo("Memo " + i));
        }
        return listMemo;
    }

    @Override
    public void onClick(View v) {

        // handle OK button click to insert a new memo in the recycler view
        if (v.getId() == R.id.memo_ok_button) {
            EditText memoET = findViewById(R.id.memo_text_et);
            listMemo.add(new Memo(memoET.getText().toString()));
            memoAdapter.notifyItemInserted(listMemo.size() - 1);
        }
    }
}

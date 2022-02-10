package dev.ogabek.java.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.adapter.InfoPageAdapter;
import dev.ogabek.java.model.InfoPage;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView skip;
    private Button getStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_main);
        skip = findViewById(R.id.tv_skip);
        getStarted = findViewById(R.id.btn_get_started);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        InfoPageAdapter adapter = new InfoPageAdapter(this, prepareInfoList());
        recyclerView.setAdapter(adapter);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int offset = recyclerView.computeHorizontalScrollOffset();
                if (offset % recyclerView.getWidth() == 0) {
                    int position = offset / recyclerView.getWidth();
                    if (position == 2) {
                        skip.setVisibility(View.GONE);
                        getStarted.setVisibility(View.VISIBLE);
                    } else {
                        skip.setVisibility(View.VISIBLE);
                        getStarted.setVisibility(View.GONE);
                    }
                }
            }
        });

    }

    private List<InfoPage> prepareInfoList() {
        List<InfoPage> infoList = new ArrayList<>();
        infoList.add(new InfoPage("topup.json", "Say Hello to Global Top-Up", "Send mobile top-up to more than 500 networks in over 140 countries."));
        infoList.add(new InfoPage("safe.json", "Safe Trusted & Fully Secure", "Encrypted transactions mean your payment & Privacy and Protected."));
        infoList.add(new InfoPage("easy.json", "Easy to Use", "Pick a number, choose an amount, send your Top-up, Simple"));
        return infoList;
    }
}
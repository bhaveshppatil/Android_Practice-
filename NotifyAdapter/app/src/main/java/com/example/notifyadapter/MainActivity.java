package com.example.notifyadapter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickListener {
    private ArrayList<TopicModel> modelArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView tvCategory;
    private CardView cardView;
    private TopicAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        tvCategory = findViewById(R.id.tvCategory);
        cardView = findViewById(R.id.crdView);
        buildCategory();
        setRecyclerView();

        getSupportActionBar().hide();
    }

    private void setRecyclerView() {
        adapter = new TopicAdapter(modelArrayList, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void buildCategory() {
        modelArrayList.add(new TopicModel("Book", false));
        modelArrayList.add(new TopicModel("Podcasts", false));
        modelArrayList.add(new TopicModel("News", false));
        modelArrayList.add(new TopicModel("Business", false));
        modelArrayList.add(new TopicModel("Entertainment", false));
        modelArrayList.add(new TopicModel("Sports", false));
        modelArrayList.add(new TopicModel("Technology", false));
        modelArrayList.add(new TopicModel("Pronunciation", false));
        modelArrayList.add(new TopicModel("Grammar", false));
        modelArrayList.add(new TopicModel("Health", false));
        modelArrayList.add(new TopicModel("Sports", false));
        modelArrayList.add(new TopicModel("Technology", false));
        modelArrayList.add(new TopicModel("Pronunciation", false));
        modelArrayList.add(new TopicModel("Grammar", false));
        modelArrayList.add(new TopicModel("Business", false));

    }

    @Override
    public void onItemClicked(int position, TopicModel model) {
        TopicModel model1;

        if (model.isItemSelected()) {
            model1 = new TopicModel(model.getTvCategory(),false);
        }else {
            model1 = new TopicModel(model.getTvCategory(), true);
        }
        modelArrayList.set(position,model1);
        adapter.notifyDataSetChanged();
    }
}
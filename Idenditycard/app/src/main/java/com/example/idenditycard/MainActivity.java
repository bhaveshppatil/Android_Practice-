package com.example.idenditycard;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickListener {
    private RecyclerView recyclerView;
    private ArrayList<CardModel> cardModelsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildCardData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        CardAdapter cardAdapter = new CardAdapter(cardModelsList, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cardAdapter);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rclView);
    }

    private void buildCardData() {
        cardModelsList = new ArrayList<>();
        cardModelsList.add(new CardModel("Tesla", "Elon Musk", 49, R.drawable.elon_musk, "Business"));
        cardModelsList.add(new CardModel("Amazon", "Jeff Benzos", 57, R.drawable.jeff_benzos, "business "));
        cardModelsList.add(new CardModel("LVMH", "Bernard Arnault", 72, R.drawable.bernard_arnault, "businessman"));
        cardModelsList.add(new CardModel("Microsoft", "Bill Gates", 65, R.drawable.bill_gates, "businessman"));
        cardModelsList.add(new CardModel("Masai School", "Prateek sukla", 31, R.drawable.prateek_sukla_1, "businessman"));
        cardModelsList.add(new CardModel("The Boring Company", "Elon Musk", 49, R.drawable.elon_musk, "Business"));
        cardModelsList.add(new CardModel("Facebook", "Mark Zuckerberg", 37, R.drawable.mark_zuk, "businessman"));
        cardModelsList.add(new CardModel("Berkshire Hathaway", "Warren Buffett", 90, R.drawable.warren_buffett, "businessman"));
        cardModelsList.add(new CardModel("Google", "Sundar Pichai", 49, R.drawable.sundar_pichai_2, "businessman"));
        cardModelsList.add(new CardModel("SpaceX", "Elon Musk", 49, R.drawable.elon_musk, "Business"));

    }

    @Override
    public void onItemClick(int position, CardModel cardModel) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(cardModel.getTvCompany().toUpperCase())
                .setMessage("Name: " + cardModel.getTvName()+ "\n" +
                        "Age: " + cardModel.getTvAge())
                .setIcon(cardModel.getImgID())
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
    }
}
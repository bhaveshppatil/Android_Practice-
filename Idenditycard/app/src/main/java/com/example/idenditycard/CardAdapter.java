package com.example.idenditycard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardDataHolder> {
    private ArrayList<CardModel> cardModelsList;
    private ClickListener clickListener;

    public CardAdapter(ArrayList<CardModel> cardModelsList, ClickListener clickListener) {
        this.cardModelsList = cardModelsList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public CardDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.id_card_items, parent,false);
        return new CardDataHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CardDataHolder holder, int position) {
        CardModel cardModel = cardModelsList.get(position);
        holder.setCardData(cardModel);

    }

    @Override
    public int getItemCount() {
        return cardModelsList.size();
    }
}

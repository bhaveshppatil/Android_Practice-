package com.example.notifyadapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class TopicViewHolder extends RecyclerView.ViewHolder {
    private TextView tvCategory;
    private CardView cardView;
    private ClickListener clickListener;

    public TopicViewHolder(@NonNull View itemView, ClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        initView(itemView);

    }

    private void initView(View itemView) {
        tvCategory = itemView.findViewById(R.id.tvCategory);
        cardView = itemView.findViewById(R.id.crdView);

    }

    public void setData(TopicModel topicModel) {
        tvCategory.setText(topicModel.getTvCategory());

        if (topicModel.isItemSelected()){
            cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.getContext(), R.color.light_blue));
            tvCategory.setTextColor(ContextCompat.getColor(tvCategory.getContext(),R.color.white));
        }else {
            cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.getContext(), R.color.white));
            tvCategory.setTextColor(ContextCompat.getColor(tvCategory.getContext(), R.color.light_blue));
        }

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClicked(getAdapterPosition(), topicModel);
            }
        });
    }
}

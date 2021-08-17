package com.example.idenditycard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CardDataHolder extends RecyclerView.ViewHolder {

    private ImageView imgFounder;
    private TextView tvCompany;
    private TextView tvName;
    private TextView tvAge;
    private TextView tvProfession;
    private CardView cardView;
    private ClickListener clickListener;

    public CardDataHolder(@NonNull View itemView, ClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        initViews(itemView);
    }

    private void initViews(View view) {
        imgFounder = view.findViewById(R.id.imgFounder);
        tvCompany = view.findViewById(R.id.tvCompany);
        tvName = view.findViewById(R.id.tvName);
        tvAge = view.findViewById(R.id.tvAge);
        tvProfession = view.findViewById(R.id.tvProfession);
        cardView = view.findViewById(R.id.crdViews);

    }

    public void setCardData(CardModel cardModel) {
        imgFounder.setImageResource(cardModel.getImgID());
        tvCompany.setText(cardModel.getTvCompany());
        tvName.setText(cardModel.getTvName());
        tvAge.setText(cardModel.getTvAge() + "");
        tvProfession.setText(cardModel.getTvProfession());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(getAdapterPosition(), cardModel);
            }
        });
    }
}

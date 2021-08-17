package com.example.articlescrollingwithrecyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleDataHolder extends RecyclerView.ViewHolder {
    private ImageView imgArticle;
    private TextView tvHeading;
    private TextView tvContent;
    private ItemClickListener clickListener;
    private CardView crdItemView;

    public ArticleDataHolder(@NonNull View itemView, ItemClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        initViews(itemView);

    }

    private void initViews(View itemView) {
        imgArticle = itemView.findViewById(R.id.imgArticle);
        tvHeading = itemView.findViewById(R.id.tvHeading);
        tvContent = itemView.findViewById(R.id.tvContent);
        crdItemView = itemView.findViewById(R.id.crdItemView);
        crdItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(getAdapterPosition());
            }
        });
    }

    public void setData(Article article) {
        imgArticle.setImageResource(article.getImageArticle());
        tvContent.setText(article.getTvContent());
        tvHeading.setText(article.getTvHeading());
    }
}

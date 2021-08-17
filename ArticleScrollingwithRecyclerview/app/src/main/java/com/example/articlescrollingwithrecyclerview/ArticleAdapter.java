package com.example.articlescrollingwithrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleDataHolder> {

    private ArrayList<Article> articleList;
    private ItemClickListener clickListener;


    public ArticleAdapter(ArrayList<Article> articleList,ItemClickListener clickListener) {
        this.articleList = articleList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ArticleDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_view, parent, false);
        return new ArticleDataHolder(view,clickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull ArticleDataHolder holder, int position) {
        Article article = articleList.get(position);
        holder.setData(article);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}

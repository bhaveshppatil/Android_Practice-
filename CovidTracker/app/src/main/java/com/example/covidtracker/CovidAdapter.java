package com.example.covidtracker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CovidAdapter extends RecyclerView.Adapter<CovidViewHolder>{

    private List<ResponseModel> responseModelList = new ArrayList<>();
    private ClickListener clickListener;
    private Context context;

    public CovidAdapter(List<ResponseModel> responseModelList, ClickListener clickListener) {
        this.responseModelList = responseModelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public CovidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covid_item, parent, false);
        return new CovidViewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidViewHolder holder, int position) {
        ResponseModel responseModel = responseModelList.get(position);
        holder.setCovidData(responseModel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String url = "https://www.masaischool.com/";
                intent.setData(Uri.parse(url));
                context.startActivity(Intent.createChooser(intent, "Opening"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }
}

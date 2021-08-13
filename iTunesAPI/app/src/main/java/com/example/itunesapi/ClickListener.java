package com.example.itunesapi;

import com.example.itunesapi.Model.ResultsModel;

public interface ClickListener {
    void onItemClick(ResultsModel resultsModel, int position);
    void remove(ResultsModel  resultsModel);
}

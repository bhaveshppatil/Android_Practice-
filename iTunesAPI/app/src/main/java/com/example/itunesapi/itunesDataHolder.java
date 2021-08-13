package com.example.itunesapi;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.itunesapi.Model.ResponseModel;
import com.example.itunesapi.Model.ResultsModel;

public class itunesDataHolder extends RecyclerView.ViewHolder {

    public ImageView ivThumbnail, ivPlay, ivPause, ivStop, ivDelete;
    private TextView tvArttistName, tvTrackName;
    private ClickListener clickListener;

    public itunesDataHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {

        ivThumbnail = itemView.findViewById(R.id.trackThumbnail);
        ivPlay = itemView.findViewById(R.id.ivPlay);
        ivPause = itemView.findViewById(R.id.ivPause);
        tvArttistName = itemView.findViewById(R.id.artistName);
        tvTrackName = itemView.findViewById(R.id.trackName);
        ivDelete = itemView.findViewById(R.id.ivDelete);

    }

    public void setData(ResultsModel resultsModel, ClickListener clickListener) {
        tvTrackName.setText(resultsModel.getTrackName());
        tvArttistName.setText(resultsModel.getArtistName());
        Glide.with(ivThumbnail).load(resultsModel.getArtworkUrl100()).into(ivThumbnail);
        String trackUrl = resultsModel.getPreviewUrl();
        Uri uri = Uri.parse(trackUrl);

        MediaPlayer mediaPlayer = MediaPlayer.create(tvTrackName.getContext(),uri);
        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        ivPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.remove(resultsModel);
            }

        });
    }
}

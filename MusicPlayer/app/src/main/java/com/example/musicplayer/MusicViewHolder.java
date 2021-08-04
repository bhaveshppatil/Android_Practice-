package com.example.musicplayer;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MusicViewHolder extends RecyclerView.ViewHolder {
    private TextView tvSongName, tvDuration;
    private ImageView btnPlay, btnPause, btnDelete;
    private ImageView imgPicture;
    private SeekBar seekBar;
    private CardView cardView;
    private ClickListener clickListener;

    public MusicViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        tvSongName = itemView.findViewById(R.id.tvSongNameAUD);
        tvDuration = itemView.findViewById(R.id.tvDurationTotal);
        btnPlay = itemView.findViewById(R.id.btnPlay);
        btnPause = itemView.findViewById(R.id.btnPause);
        btnDelete = itemView.findViewById(R.id.btnDelete);
        imgPicture = itemView.findViewById(R.id.imgCover);
        seekBar = itemView.findViewById(R.id.seekbar);
        cardView = itemView.findViewById(R.id.cardView);

    }

    public void setData(MusicModel musicModel, ClickListener clickListener) {
        tvSongName.setText(musicModel.getTvSongName());
        imgPicture.setImageResource(musicModel.getImgID());

        MediaPlayer mediaPlayer = MediaPlayer.create(tvSongName.getContext(), musicModel.getResID());
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                tvDuration.setText(mediaPlayer.getDuration()+"");
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.remove(musicModel);
            }
        });
    }
}

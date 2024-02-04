package com.example.videoplayer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewholder extends RecyclerView.ViewHolder {
    ImageView videoimg;
    TextView videotxt;
    public viewholder(@NonNull View itemView) {
        super(itemView);
        videoimg=itemView.findViewById(R.id.videoview);
        videotxt=itemView.findViewById(R.id.videotext);
    }
}

package com.example.recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myViewholder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView text;
    public myViewholder(@NonNull View itemView) {
        super(itemView);
        image=(ImageView) itemView.findViewById(R.id.image);
        text=(TextView) itemView.findViewById(R.id.name);



    }
}

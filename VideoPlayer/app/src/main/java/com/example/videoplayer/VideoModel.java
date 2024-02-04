package com.example.videoplayer;

public class VideoModel {
    String Title;
    String Data;

    public VideoModel(String title, String data) {
        Title = title;
        Data = data;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}

package com.example.newsapp;

import java.util.ArrayList;

public class NewsModel {
    private int totalResult;
    private ArrayList<Articles> articles;

    public NewsModel(int totalResult, ArrayList<Articles> articles) {
        this.totalResult = totalResult;
        this.articles = articles;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }
}

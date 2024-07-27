package com.example.newsapp;

public class CategoryModel {
    String Category,Image;

    public CategoryModel(String category, String image) {
        Category = category;
        Image = image;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}

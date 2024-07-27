package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements CategoryRecycler.CategoryClick{
    RecyclerView categoryrv,newsrv;
    ArrayList<CategoryModel> categoryModelArrayList;
    ArrayList<Articles> articlesArrayList;
    CategoryRecycler categoryRecycler;
    NewsRecycler newsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categoryrv=findViewById(R.id.recyclercateg);
        newsrv=findViewById(R.id.recyclernews);
        categoryModelArrayList=new ArrayList<>();
        articlesArrayList=new ArrayList<>();
        categoryRecycler=new CategoryRecycler(categoryModelArrayList,getApplicationContext(),this::click);
        newsRecycler=new NewsRecycler(articlesArrayList,getApplicationContext());
        newsrv.setLayoutManager(new LinearLayoutManager(this));
        newsrv.setAdapter(newsRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryrv.setLayoutManager(layoutManager);
        categoryrv.setAdapter(categoryRecycler);
        getCategories();
        Newsdata("All");
        newsRecycler.notifyDataSetChanged();



    }

    public void getCategories(){
        categoryModelArrayList.add(new CategoryModel("TECHNOLOGY","https://images.unsplash.com/photo-1518770660439-4636190af475?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"));
        categoryModelArrayList.add(new CategoryModel("SCIENCE","https://images.unsplash.com/photo-1532094349884-543bc11b234d?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"));
        categoryModelArrayList.add(new CategoryModel("HEALTH","https://images.unsplash.com/photo-1498837167922-ddd27525d352?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"));
        categoryModelArrayList.add(new CategoryModel("SPORTS","https://images.unsplash.com/photo-1471295253337-3ceaaedca402?q=80&w=1468&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"));
        categoryModelArrayList.add(new CategoryModel("ENTERTAINMENT","https://images.unsplash.com/photo-1510511233900-1982d92bd835?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"));
        categoryModelArrayList.add(new CategoryModel("EDUCATION","https://images.unsplash.com/photo-1497633762265-9d179a990aa6?q=80&w=1473&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"));

   categoryRecycler.notifyDataSetChanged();
    }
    public void Newsdata(String Category){
        articlesArrayList.clear();
        String CategoryURL="https://newsapi.org/v2/top-headlines?country=in&category="+Category+"&apiKey=ab655031c4624cd5a84c28cc16f9972e";
        String url="https://newsapi.org/v2/top-headlines?country=in&apiKey=ab655031c4624cd5a84c28cc16f9972e";
        String BASE_URL="https://newsapi.org/";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI=retrofit.create(RetrofitAPI.class);
        Call<NewsModel> call;
        if (Category.equals("All")){
            call=retrofitAPI.getallnews(url);
        }
        else {
            call=retrofitAPI.getallnews(CategoryURL);

        }
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                NewsModel newsModel=response.body();
                ArrayList<Articles> articles=newsModel.getArticles();
                for (int i=0;i<articles.size();i++){
                    articlesArrayList.add(new Articles(articles.get(i).getAuthor(),articles.get(i).getTitle(),articles.get(i).getDescription(),articles.get(i).getUrlToImage(),articles.get(i).getContent(),articles.get(i).getUrl()));
                }
                newsRecycler.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void click(int position) {
        String category=categoryModelArrayList.get(position).getCategory();
        Newsdata(category);
        newsRecycler.notifyDataSetChanged();
    }

}

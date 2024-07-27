package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;

import java.util.Locale;

public class DetailNews extends AppCompatActivity {
ImageView image,send;
LottieAnimationView lottieAnimationView;
TextView title,author,desc;
TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        image=findViewById(R.id.image);
        title=findViewById(R.id.title);
        author=findViewById(R.id.author);
        desc=findViewById(R.id.desc);
        send=findViewById(R.id.send);
        lottieAnimationView=findViewById(R.id.animation_view);
        String url=getIntent().getStringExtra("url");


        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });
        String titles=getIntent().getStringExtra("title");
        String content=getIntent().getStringExtra("content");

        title.setText(titles);
        author.setText(getIntent().getStringExtra("author"));
        desc.setText(content);
        Glide.with(this).load(getIntent().getStringExtra("image")).into(image);
        lottieAnimationView.pauseAnimation();

        String speakdata="Title is"+titles+"and the content is "+content+"to know more information visit to official website Thank You";
        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(speakdata,TextToSpeech.QUEUE_FLUSH,null);
                if (textToSpeech.isSpeaking()){
                    lottieAnimationView.playAnimation();
                }
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Link");
                shareIntent.putExtra(Intent.EXTRA_TEXT, url);
                String chooserTitle = "Share via";
                Intent chooser = Intent.createChooser(shareIntent, chooserTitle);
                startActivity(chooser);
            }
        });

    }
}
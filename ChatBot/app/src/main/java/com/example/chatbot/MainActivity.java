package com.example.chatbot;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText editText;
    private FloatingActionButton button;
    private static final String USER_KEY = "user";
    private static final String BOT_KEY = "bot";
    private ChatAdaptor chatAdapter;
    private ArrayList<ChatModel> chatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        editText = findViewById(R.id.textsend);
        button = findViewById(R.id.send);

        chatList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter = new ChatAdaptor(chatList, getApplicationContext());
        recyclerView.setAdapter(chatAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMessage = editText.getText().toString().trim();
                if (userMessage.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter your message", Toast.LENGTH_SHORT).show();
                } else {
                    sendMessage(userMessage);
                    editText.setText("");
                }
            }
        });
    }

    private void sendMessage(String message) {
        chatList.add(new ChatModel(message, USER_KEY));
        chatAdapter.notifyDataSetChanged();

        // Retrofit setup
        String baseUrl = "https://api.brainshop.ai/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        String apiKey = "EvX4Ea84uM6dWalc";
        String url = "get?bid=180623&key=" + apiKey + "&uid=[uid]&msg=" + message;

        Call<MessageModel> call = retrofitApi.getmessage(url);
        call.enqueue(new Callback<MessageModel>() {
            @Override
            public void onResponse(Call<MessageModel> call, Response<MessageModel> response) {
                if (response.isSuccessful()) {
                    MessageModel msgModel = response.body();
                    if (msgModel != null) {
                        String botResponse = msgModel.getCnt();
                        chatList.add(new ChatModel(botResponse, BOT_KEY));
                        chatAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<MessageModel> call, Throwable t) {
                chatList.add(new ChatModel("Please revert your question", BOT_KEY));
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                chatAdapter.notifyDataSetChanged();
            }
        });
    }
}

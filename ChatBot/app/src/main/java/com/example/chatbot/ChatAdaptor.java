package com.example.chatbot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChatAdaptor extends RecyclerView.Adapter {
    ArrayList<ChatModel> modelArrayList;
    Context context;

    public ChatAdaptor(ArrayList<ChatModel> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case 0:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg,parent,false);
                return new User_ViewHolder(view);
            case 1:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg,parent,false);
                return new Bot_ViewHolder(view);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatModel model=modelArrayList.get(position);
        switch (model.getSender()){
            case "user":
                ((User_ViewHolder)holder).user_chat.setText(model.getMessage());
                break;
            case "bot":
                ((Bot_ViewHolder)holder).bot_chat.setText(model.getMessage());
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (modelArrayList.get(position).getSender()){
            case "user":
                return 0;
            case "bot":
                return 1;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
    public class User_ViewHolder extends RecyclerView.ViewHolder{
           TextView user_chat;
        public User_ViewHolder(@NonNull View itemView) {
            super(itemView);
            user_chat=itemView.findViewById(R.id.user_text);
        }
    }
    public class Bot_ViewHolder extends RecyclerView.ViewHolder{
        TextView bot_chat;
        public Bot_ViewHolder(@NonNull View itemView) {
            super(itemView);
            bot_chat=itemView.findViewById(R.id.robot_text);
        }
    }
}

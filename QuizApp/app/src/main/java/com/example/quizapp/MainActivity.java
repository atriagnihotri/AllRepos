package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView attempt,question;
Button opt1,opt2,opt3,opt4;
ArrayList<QuizModal> arrayList;

int currentpos=0,score=0,totalquestion=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attempt=findViewById(R.id.qattempt);
        question=findViewById(R.id.questions);
        opt1=findViewById(R.id.op1);
        opt2=findViewById(R.id.op2);
        opt3=findViewById(R.id.op3);
        opt4=findViewById(R.id.op4);
        arrayList=new ArrayList<>();

        arrayList.add(new QuizModal("What is the capital of Australia?","Sydney","Melbourne","Canberra","Brisbane","Canberra"));
        arrayList.add(new QuizModal("Who wrote the play Romeo and Juliet?","William Shakespeare","Charles Dickens","Mark Twain","Jane Austen","William Shakespeare"));
        arrayList.add(new QuizModal("Which planet is known as the Red Planet?","Venus"," Mars","Jupiter","Saturn","Mars"));
        arrayList.add(new QuizModal("What is the largest mammal in the world?","Elephant","Blue Whale"," Giraffe","Hippopotamus","Blue Whale"));
        arrayList.add(new QuizModal("What is the chemical symbol for water?","O2","CO2","H2O","NaCl","H2O"));

          totalquestion=arrayList.size();

         QuizQuestion(currentpos);
         opt1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 if (arrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(opt1.getText().toString().trim().toLowerCase())){
                     score++;
                 }
                 currentpos++;
                 QuizQuestion(currentpos);
             }
         });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (arrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(opt2.getText().toString().trim().toLowerCase())){
                    score++;
                }
                currentpos++;
                QuizQuestion(currentpos);
            }
        });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (arrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(opt3.getText().toString().trim().toLowerCase())){
                    score++;
                }
                currentpos++;
                QuizQuestion(currentpos);
            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (arrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(opt4.getText().toString().trim().toLowerCase())){
                    score++;
                }
                currentpos++;
                QuizQuestion(currentpos);
            }
        });


    }
    private void QuizQuestion(int currentpos){
        if (currentpos==arrayList.size()){
            Toast.makeText(this, "Your Score is "+score+"/"+totalquestion, Toast.LENGTH_LONG).show();
        }
        else {
            attempt.setText(currentpos + 1 + "/" + totalquestion);
            question.setText(arrayList.get(currentpos).getQuestion());
            opt1.setText(arrayList.get(currentpos).getOpt1());
            opt2.setText(arrayList.get(currentpos).getOpt2());
            opt3.setText(arrayList.get(currentpos).getOpt3());
            opt4.setText(arrayList.get(currentpos).getOpt4());
        }

    }

}
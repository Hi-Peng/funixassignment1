package com.losdol.prm391x_quizapp_hidayatmhyfx07085;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class quizMain extends AppCompatActivity {
    //Initializing some important variable
    public int correctAnswerCount;

    //Initializing ui component
    Button submitButton;
    String username;

    RadioGroup answer_1, answer_5, answer_9;
    RadioButton answer_1_c, answer_5_b, answer_9_b;

    EditText answer_2, answer_4, answer_6, answer_8, answer_10;

    CheckBox answer_3_a, answer_3_c, answer_7_c, answer_7_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_main);

        // Intent for passing the login name string, i've just read the documentation from google about
        // using intent and bundle as a way to pass variable between activity
        Intent i = getIntent(); //Getting intent from previous activity
        Bundle name = i.getBundleExtra("loginInfo"); //Getting bundle from intent
        username = name.getString("examineeName"); //Casting the bundle object to String variable "username"

        //Below this, just some UI component registry
        submitButton = (Button) findViewById(R.id.submit_button);

        answer_1 = (RadioGroup) findViewById(R.id.answer_1) ;
        answer_1_c = findViewById(R.id.answer_1_c);

        answer_2 = (EditText) findViewById(R.id.answer_2);

        answer_3_a = findViewById(R.id.answer_3_a);
        answer_3_c = findViewById(R.id.answer_3_c);

        answer_4 = findViewById(R.id.answer_4);

        answer_5 = findViewById(R.id.answer_5);
        answer_5_b = findViewById(R.id.answer_5_b);

        answer_6 = findViewById(R.id.answer_6);

        answer_7_c = findViewById(R.id.answer_7_c);
        answer_7_d = findViewById(R.id.answer_7_d);

        answer_8 = findViewById(R.id.answer_8);

        answer_9 = findViewById(R.id.answer_9);
        answer_9_b  = findViewById(R.id.answer_9_b);

        answer_10 = findViewById(R.id.answer_10);

        //Listen to button press
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bunch of if for correction
                //I know, using if statement take a lot computing resource (slow).
                //Maybe next time i will considered to not use if else as possible
                if(answer_1.getCheckedRadioButtonId() == answer_1_c.getId()){
                    correctAnswerCount++;
                    Log.d("Quiz", "(No.1 Correct) Correct Answer:" + correctAnswerCount);
                }
                if(answer_2.getText().toString().equals("Vulcanizing")){
                    correctAnswerCount++;
                    Log.d("Quiz", "(No.2 Correct) Correct Answer:" + correctAnswerCount);
                }
                if(answer_3_a.isChecked() && answer_3_c.isChecked()){
                    correctAnswerCount++;
                    Log.d("Quiz", "(No.3 Correct) Correct Answer:" + correctAnswerCount);
                }
                if(answer_4.getText().toString().equals("Gravity")){
                    correctAnswerCount++;
                    Log.d("Quiz", "(No.4 Correct) Correct Answer:" + correctAnswerCount);
                }
                if(answer_5.getCheckedRadioButtonId() == answer_5_b.getId()){
                    correctAnswerCount++;
                    Log.d("Quiz", "(No.5 Correct) Correct Answer:" + correctAnswerCount);
                }
                if(answer_6.getText().toString().equals("Clouds")){
                    correctAnswerCount++;
                    Log.d("Quiz", "(No.6 Correct) Correct Answer:" + correctAnswerCount);
                }
                if(answer_7_c.isChecked() && answer_7_d.isChecked()){
                    correctAnswerCount++;
                    Log.d("Quiz", "(No.7 Correct) Correct Answer:" + correctAnswerCount);
                }
                if(answer_8.getText().toString().equals("Wrist")){
                    correctAnswerCount++;
                    Log.d("Quiz", "(No.8 Correct) Correct Answer:" + correctAnswerCount);
                }
                if(answer_9.getCheckedRadioButtonId() == answer_9_b.getId()){
                    correctAnswerCount++;
                    Log.d("Quiz", "(No.9 Correct) Correct Answer:" + correctAnswerCount);
                }
                if(answer_10.getText().toString().equals("Smelting")){
                    correctAnswerCount++;
                    Log.d("Quiz", "(No.10 Correct) Correct Answer:" + correctAnswerCount);
                }

                //Toast result announcement
                if(correctAnswerCount == 10){
                    Toast.makeText(getApplicationContext(),
                            "Perfect, " + username + " scored " + correctAnswerCount + " out of 10",
                            Toast.LENGTH_LONG)
                            .show();
                    submitButton.setEnabled(false); //Prevent the examinees to take the quiz again
                }

                else if(correctAnswerCount > 10){
                    Toast.makeText(getApplicationContext(),
                            "You Already Did The Quiz",
                            Toast.LENGTH_LONG)
                            .show();
                    submitButton.setEnabled(false); //Prevent the examinees to take the quiz again
                }
                else
                    Toast.makeText(getApplicationContext(),
                            "Try again, " + username+ " scored " + correctAnswerCount + " out of 10",
                            Toast.LENGTH_LONG)
                            .show();
                correctAnswerCount = 0;
            }
        });
    }
}

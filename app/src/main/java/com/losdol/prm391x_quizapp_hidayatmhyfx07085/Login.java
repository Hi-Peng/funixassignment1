package com.losdol.prm391x_quizapp_hidayatmhyfx07085;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    public String examinee_name;

    EditText examinee_name_etext;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        examinee_name_etext = findViewById(R.id.examinee_name);
        submit = findViewById(R.id.examinee_name_submit);

        //Button listner
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Passing the login info to the quizMain activity
                Intent i = new Intent(Login.this, quizMain.class);
                examinee_name = examinee_name_etext.getText().toString();
                Bundle name = new Bundle();
                name.putString("examineeName", examinee_name);
                i.putExtra("loginInfo", name);
                startActivity(i);
            }
        });
    }
}

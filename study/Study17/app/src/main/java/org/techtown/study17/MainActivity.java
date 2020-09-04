package org.techtown.study17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;
    EditText input3;
    EditText input4;
    EditText input5;
    EditText input6;
    EditText input7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        input4 = findViewById(R.id.input4);
        input5 = findViewById(R.id.input5);
        input6 = findViewById(R.id.input6);
        input7 = findViewById(R.id.input7);

    }

    public void onButton1Clicked(View v) {
        String name = input1.getText().toString();
        String age = input2.getText().toString();

        String text1 = input3.getText().toString();
        String text2 = input4.getText().toString();
        String text3 = input5.getText().toString();
        String text4 = input6.getText().toString();
        String text5 = input7.getText().toString();

        Toast.makeText(getApplicationContext(), "학생 프로필 저장됨 : " + name + ", " + age, Toast.LENGTH_LONG).show();

    }

    public void onButton2Clicked(View v) {
        finish();
    }

}
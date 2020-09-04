package org.techtown.study11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Singer singer1;
    Singer singer2;

    EditText input1;
    EditText input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);

    }

    public void onButton1Clicked(View v) {
        String name = input1.getText().toString();
        String age = input2.getText().toString();

        int ageInt = 0;
        try {
            ageInt = Integer.parseInt(age);
        } catch(Exception e) {
            e.printStackTrace();
        }

        singer1 = new Singer(name, ageInt);

        Toast.makeText(getApplicationContext(), "가수 추가됨 : " + singer1.getName() + ", 가수의 나이 : " + singer1.getAge(), Toast.LENGTH_LONG).show();
    }

    public void onButton2Clicked(View v) {
        String name = input1.getText().toString();
        String age = input2.getText().toString();

        int ageInt = 0;
        try {
            ageInt = Integer.parseInt(age);
        } catch(Exception e) {
            e.printStackTrace();
        }

        singer2 = new GirlGroupSinger(name, ageInt);

        Toast.makeText(getApplicationContext(), "걸그룹 추가됨 : " + singer2.getName() + ", 걸그룹의 나이 : " + singer2.getAge(), Toast.LENGTH_LONG).show();
    }

}
package org.techtown.study13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;
    TextView output1;

    School school = new School("우리 학교");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        output1 = findViewById(R.id.output1);
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

        Student student = new Student(name, ageInt);
        school.addItem(student);

        Toast.makeText(getApplicationContext(), "학생 객체가 리스트에 추가됨 : " + student.getName() + ", 학생의 나이 : " + student.getAge(), Toast.LENGTH_LONG).show();

        output1.setText("추가된 학생의 총 수 : " + school.size() + "명");
    }

}
package org.techtown.study16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;

    School school = new School("우리 학교");

    Stack<Student> stack = new Stack<Student>();

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

        Student student = new Student(name, ageInt);
        school.addItem(student);

        stack.push(student);

        Toast.makeText(getApplicationContext(), "학생 객체가 리스트에 추가됨 : " + student.getName() + ", 학생의 나이 : " + student.getAge(), Toast.LENGTH_LONG).show();


        Intent intent = new Intent(this, StudentInfoActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("age", age);

        startActivity(intent);

    }

    public void onButton2Clicked(View v) {
        Student student = stack.pop();

        String name = student.getName();
        int ageInt = student.getAge();
        String age = String.valueOf(ageInt);

        Intent intent = new Intent(this, StudentInfoActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("age", age);

        startActivity(intent);

    }

}
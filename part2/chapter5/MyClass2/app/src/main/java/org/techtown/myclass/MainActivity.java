package org.techtown.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ImageView imageView;

    Person person01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        imageView = findViewById(R.id.imageView);

    }

    public void onButton1Clicked(View v) {
        String name = editText.getText().toString();
        createPerson(name);
    }

    public void createPerson(String name) {
        person01 = new Person(name, this);
    }

    public void onButton2Clicked(View v) {
        person01.walk(10);
    }

    public void onButton3Clicked(View v) {
        person01.run(10);
    }

}

class Person {
    String name;
    Leg leg = new Leg();
    MainActivity activity;

    public Person() {

    }

    public Person(String inName) {
        name = inName;
    }

    public Person(String inName, MainActivity inActivity) {
        name = inName;
        activity = inActivity;
    }

    public void walk(int speed) {
        System.out.println(name + "이(가) " + speed + "km 속도로 걸어갑니다.");

        Toast.makeText(activity.getApplicationContext(), name + "이(가) " + speed
                + "km 속도로 걸어갑니다.", Toast.LENGTH_LONG).show();

        activity.imageView.setImageResource(R.drawable.person_walk);
    }

    public void run(int speed) {
        System.out.println(name + "이(가) " + speed + "km 속도로 걸어갑니다.");

        Toast.makeText(activity.getApplicationContext(), name + "이(가) "
                + speed + "km 속도로 뛰어갑니다.", Toast.LENGTH_LONG).show();

        activity.imageView.setImageResource(R.drawable.person_run);
    }

    public Leg getLeg() {
        return leg;
    }

}

class Leg {
    String left = "왼쪽";
    String right = "오른쪽";

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}

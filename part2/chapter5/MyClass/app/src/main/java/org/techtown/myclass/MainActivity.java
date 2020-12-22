package org.techtown.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person person01 = new Person("철수", this);
        person01.walk(10);

        Person person02 = new Person("영희", this);
        person02.walk(10);

        Person person03 = new Person("민희", this);
        person03.walk(10);

        Person person04 = person03;
        person04.walk(10);

        String outName = person04.name;
        System.out.println("person04.name : " + outName);
        person03.name = "민정";

        System.out.println("person04.name : " + outName);

        Leg outLeg = person04.leg;
        System.out.println("person04.leg : " + outLeg.left);
        person03.leg.left = "왼쪽 다리";

        System.out.println("person04.leg : " + outLeg.left);

        Leg outLeg2 = person04.getLeg();
        System.out.println("person04.leg : " + outLeg2.right);
        person03.leg.right = "오른쪽 다리";

        System.out.println("person04.leg : " + outLeg2.right);
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
    }

    public void run(int speed) {
        System.out.println(name + "이(가) " + speed + "km 속도로 걸어갑니다.");
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
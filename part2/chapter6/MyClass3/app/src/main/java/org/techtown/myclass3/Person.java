package org.techtown.myclass3;

import android.widget.Toast;

public class Person {
    public String name;
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


package org.techtown.myclass;

import android.widget.Toast;

public class Baby extends Person {

    public Baby(String inName, MainActivity inActivity) {
        name = inName;
        activity = inActivity;
    }

    public void cry() {
        super.cry();

        Toast.makeText(activity.getApplicationContext(),
                name + "이(가) 웁니다.", Toast.LENGTH_LONG).show();
        activity.imageView.setImageResource(R.drawable.baby_cry);
    }

}
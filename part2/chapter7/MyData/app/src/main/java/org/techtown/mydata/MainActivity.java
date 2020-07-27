package org.techtown.mydata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name01 = "철수";
    String name02 = "영희";
    String name03 = "민희";
    String name04 = "수지";
    String name05 = "지민";

    int count = 0;

    Person person01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (count == 0) {
                    person01 = new Person(name01);
                    Toast.makeText(getApplicationContext(),
                            "사람 " + name01 + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();
                } else if (count == 1) {
                    person01 = new Person(name02);
                    Toast.makeText(getApplicationContext(),
                            "사람 " + name02 + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();
                } else if (count == 2) {
                    person01 = new Person(name03);
                    Toast.makeText(getApplicationContext(),
                            "사람 " + name03 + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();
                } else if (count == 3) {
                    person01 = new Person(name04);
                    Toast.makeText(getApplicationContext(),
                            "사람 " + name04 + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();
                } else if (count == 4) {
                    person01 = new Person(name05);
                    Toast.makeText(getApplicationContext(),
                            "사람 " + name05 + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();
                }

                count++;
            }

        });

    }
}

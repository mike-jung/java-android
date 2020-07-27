package org.techtown.mydata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] names = {"철수", "영희", "민희", "수지", "지민"};

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
                if (count < names.length) {
                    person01 = new Person(names[count]);
                    Toast.makeText(getApplicationContext(),
                            "사람 " + names[count] + "이 만들어졌습니다.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "사람 이름이 없습니다.",
                            Toast.LENGTH_LONG).show();
                }

                count++;

                for (int i = 0; i < names.length; i++) {
                    System.out.println(i + " : " + names[i]);
                }

            }

        });

    }
}

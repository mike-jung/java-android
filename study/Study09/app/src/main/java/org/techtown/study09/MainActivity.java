package org.techtown.study09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Singer singer1;
    Singer singer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singer1 = new Singer("조용필", 20);
        singer2 = new Singer("남진", 22);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "가수의 이름 : " + singer1.name + " , 가수의 나이 : " + singer1.age, Toast.LENGTH_LONG).show();
            }

        });

        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "가수의 이름 : " + singer2.name + " , 가수의 나이 : " + singer2.age, Toast.LENGTH_LONG).show();
            }

        });

    }
}
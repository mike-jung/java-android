package com.example.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                // onClick 메서드 안에 입력하기
                Toast.makeText(getApplicationContext(), "버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void onButton1Clicked(View v) {
        Toast.makeText(this, "버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
    }

}

package org.techtown.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class Calculator {

        public int add(int a, int b) {
            Toast.makeText(getApplicationContext(), "더하기를 했습니다.",
                    Toast.LENGTH_LONG).show();
            return a + b;
        }

    }

}



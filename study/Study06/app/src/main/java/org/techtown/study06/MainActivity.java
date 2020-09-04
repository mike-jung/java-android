package org.techtown.study06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;
    EditText input3;
    TextView output1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        output1 = findViewById(R.id.output1);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = input1.getText().toString();
                String age = input2.getText().toString();
                String address = input3.getText().toString();

                output1.setText("입력된 값 : " + name + ", " + age + ", " + address);

                int inputAge = Integer.parseInt(age);
                if (inputAge > 30) {
                    Toast.makeText(getApplicationContext(), "나이가 30살보다 많습니다.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "나이가 30살 이하입니다.", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
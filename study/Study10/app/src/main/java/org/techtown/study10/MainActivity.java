package org.techtown.study10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Singer singer1;
    Singer singer2;

    RadioButton radioButton;
    RadioButton radioButton2;

    EditText input1;
    EditText input2;

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

        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);

    }

    public void onButton1Clicked(View v) {
        String name = input1.getText().toString();
        String age = input2.getText().toString();

        int ageInt = 0;
        try {
            ageInt = Integer.parseInt(age);
        } catch(Exception e) {
            e.printStackTrace();
        }

        if (radioButton.isChecked()) {
            singer1.setName(name);
            singer1.setAge(ageInt);

            Toast.makeText(getApplicationContext(), "입력한 값이 첫번째 Singer 객체에 설정되었습니다.", Toast.LENGTH_LONG).show();
        } else if (radioButton2.isChecked()) {
            singer2.setName(name);
            singer2.setAge(ageInt);

            Toast.makeText(getApplicationContext(), "입력한 값이 두번째 Singer 객체에 설정되었습니다.", Toast.LENGTH_LONG).show();
        }

    }

    public void onButton2Clicked(View v) {
        finish();
    }

}
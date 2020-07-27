package org.techtown.myclass3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ImageView imageView;

    Person person01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);

    }

    public void onButton1Clicked(View v) {
        String name = editText.getText().toString();

        RadioButton radioButton = findViewById(R.id.radioButton);
        boolean personChecked = radioButton.isChecked();

        if (personChecked) {
            createPerson(name);
        } else {
            createBaby(name);
        }

        imageView.setVisibility(View.VISIBLE);

    }

    public void createPerson(String name) {
        person01 = new Person(name, this);
    }

    public void createBaby(String name) {
        person01 = new Baby(name, this);
        imageView.setImageResource(R.drawable.baby);
    }

    public void onButton2Clicked(View v) {
        if (person01 != null) {
            person01.walk(10);
        }
    }

    public void onButton3Clicked(View v) {
        if (person01 != null) {
            person01.run(10);
        }
    }

    public void onButton4Clicked(View v) {
        if (person01 != null) {
            if (person01 instanceof Baby) {
                Baby baby01 = (Baby) person01;
                baby01.cry();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Baby 객체가 아니어서 cry 메서드를 호출할 수 없습니다.",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

}














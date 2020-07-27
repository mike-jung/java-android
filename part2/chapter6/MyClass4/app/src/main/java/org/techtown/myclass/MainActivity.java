package org.techtown.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
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

        TextView textView = findViewById(R.id.textView);
        textView.setText(Person.total + " 명");
    }

    public void createPerson(String name) {
        person01 = new Person(name, this);
        imageView.setImageResource(R.drawable.person);

        person01.age = 20;
        Person.total = Person.total + 1;
    }

    public void createBaby(String name) {
        person01 = new Baby(name, this);
        imageView.setImageResource(R.drawable.baby);

        person01.age = 1;
        Person.total = Person.total + 1;
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
            person01.cry();
        }
    }

}














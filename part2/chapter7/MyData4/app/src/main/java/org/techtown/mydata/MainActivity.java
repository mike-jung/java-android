package org.techtown.mydata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    String[] names = {"철수", "영희", "민희", "수지", "지민"};
    int count = 0;

    ArrayList<Person> persons = new ArrayList<Person>();

    TextView textView;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        linearLayout = findViewById(R.id.linearLayout);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int nameIndex = count % 5;
                Person curPerson = new Person(names[nameIndex]);
                persons.add(curPerson);
                Toast.makeText(getApplicationContext(),
                        "사람 " + names[nameIndex] + "이 만들어졌습니다.",
                        Toast.LENGTH_LONG).show();

                String curName = curPerson.getName();
                TextView nameTextView = new TextView(getApplicationContext());
                nameTextView.setText(curName);
                nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                linearLayout.addView(nameTextView, params);


                count++;

                textView.setText(count + " 명");
            }

        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editText);
                String curName = editText.getText().toString();

                Person curPerson = new Person(curName);
                persons.add(curPerson);
                Toast.makeText(getApplicationContext(),
                        "사람 " + curName + "이 만들어졌습니다.",
                        Toast.LENGTH_LONG).show();

                TextView nameTextView = new TextView(getApplicationContext());
                nameTextView.setText(curName);
                nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                linearLayout.addView(nameTextView, params);

                textView.setText(persons.size() + " 명");

                Iterator<Person> iter = persons.iterator();
                int outIndex = 0;
                while(iter.hasNext()) {
                    Person outPerson = iter.next();
                    System.out.println(outIndex + " : " + outPerson.getName());
                    outIndex++;
                }
            }

        });

    }
}

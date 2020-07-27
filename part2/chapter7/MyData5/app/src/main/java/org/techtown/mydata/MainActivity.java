package org.techtown.mydata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    String[] names = {"철수", "영희", "민희", "수지", "지민"};
    int count = 0;

    ArrayList<Person> persons = new ArrayList<Person>();

    TextView textView;

    LinearLayout linearLayout;

    String[] groups = {"친구", "가족"};

    HashMap<String, ArrayList<String>> phonebook =
            new HashMap<String, ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> friends = new ArrayList<String>();
        friends.add("철수");
        friends.add("영희");
        friends.add("민희");
        friends.add("수지");
        friends.add("지민");

        phonebook.put("친구", friends);

        ArrayList<String> family = new ArrayList<String>();
        family.add("할머니");
        family.add("할아버지");
        family.add("엄마");
        family.add("아빠");
        family.add("동생");

        phonebook.put("가족", family);


        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                groups);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "선택된 아이템 인덱스 : " + position,
                        Toast.LENGTH_LONG).show();

                String curGroup = groups[position];
                ArrayList<String> nameList = phonebook.get(curGroup);

                linearLayout.removeAllViews();
                for (int i = 0; i < nameList.size(); i++) {
                    String curName = nameList.get(i);

                    addPersonTextView(curName);

                    textView.setText(persons.size() + " 명");
                }

                printAll();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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

    public void addPersonTextView(String curName) {
        TextView nameTextView = new TextView(getApplicationContext());
        nameTextView.setText(curName);
        nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        linearLayout.addView(nameTextView, params);
    }

    public void printAll() {
        String outNames = "";
        Set<String> keys = phonebook.keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()) {
            String curGroup = iter.next();
            outNames = outNames + ("\n" + curGroup + "그룹 : ");
            ArrayList<String> nameList = phonebook.get(curGroup);
            for (int j = 0; j < nameList.size(); j++) {
                outNames = outNames + nameList.get(j);
                if (j < (nameList.size()-1)) {
                    outNames = outNames + ",";
                }
            }
        }

        System.out.println(outNames);
    }
}

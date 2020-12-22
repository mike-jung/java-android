package org.techtown.stack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    Button button2;

    Stack<Integer> stack = new Stack<Integer>();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stack.push(count);
                editText.setText("\n스택에 추가함 : " + count);

                count++;

                editText.append("\n스택 : " + stack);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int outValue = stack.pop();
                editText.setText("\n스택에서 가져옴 : " + outValue);

                editText.append("\n스택 : " + stack);
            }
        });

    }
}

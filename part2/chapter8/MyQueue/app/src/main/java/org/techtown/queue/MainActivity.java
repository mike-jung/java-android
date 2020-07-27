package org.techtown.queue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    Button button2;

    ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue.offer(count);
                editText.setText("\n큐에 추가함 : " + count);

                count++;

                editText.append("\n큐 : " + queue);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int outValue = queue.poll();
                editText.setText("\n큐에서 가져옴 : " + outValue);

                editText.append("\n큐 : " + queue);
            }
        });

    }
}

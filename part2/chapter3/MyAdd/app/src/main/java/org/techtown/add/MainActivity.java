package org.techtown.add;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    TextView textView2;

    int value05 = 100;
    final int value06 = 100;
    final static int value07 = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        textView2 = findViewById(R.id.textView2);
    }

    public void onButton1Clicked(View v) {
        String value01 = editText.getText().toString();
        String value02 = editText2.getText().toString();

        int input01 = Integer.parseInt(value01);
        int input02 = Integer.parseInt(value02);

        int value03 = input01 + input02;
        textView2.setText(String.valueOf(value03));

        final int value04 = 100;
        value03 = value03 + value04;

        textView2.setText(String.valueOf(value03));

    }

}

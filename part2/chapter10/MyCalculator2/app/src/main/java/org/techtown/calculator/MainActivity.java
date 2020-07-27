package org.techtown.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = editText.getText().toString();
                String input2 = editText2.getText().toString();

                int a = 0;
                int b = 0;
                try {
                    a = Integer.parseInt(input1);
                    b = Integer.parseInt(input2);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }

                Calculator calculator = new MyCalculator();
                int result = calculator.add(a, b);

                calculator = new FriendCalculator(getApplicationContext());
                result = calculator.add(a, b);

                editText3.setText(String.valueOf(result));
            }

        });

    }
}

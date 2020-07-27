package org.techtown.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;

    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new MyCalculator();

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

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

                int result = calculator.add(a, b);
                editText3.setText(String.valueOf(result));

                ArrayList<CalcData> history = calculator.getHistory();
                String outStr = "";
                for (int i = 0; i < history.size(); i++) {
                    CalcData curData = history.get(i);
                    outStr += "\n#" + i + " : " + curData.getA() + ", "
                            + curData.getB() + ", "
                            + curData.getType() + ", "
                            + curData.getResult();
                }

                editText4.setText(outStr);
            }

        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
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

                int result = 0;
                try {
                    result = calculator.subtract(a, b);
                } catch (UnImplementedException e) {
                    e.printStackTrace();

                    Toast.makeText(getApplicationContext(), "빼기는 안됩니다.",
                            Toast.LENGTH_LONG).show();

                }

                editText3.setText(String.valueOf(result));
            }

        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.clearHistory();
                editText4.setText("");
            }

        });

    }
}

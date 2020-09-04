package org.techtown.study08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);

    }

    public void onButton1Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton2Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton3Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton4Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton5Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton6Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton7Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton8Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton9Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton10Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton11Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton12Clicked(View v) {
        setRowColumn(v);
    }

    private void setRowColumn(View v) {
        Button button = (Button) v;
        String numberStr = button.getText().toString();

        int number = 0;
        try {
            number = Integer.parseInt(numberStr);
        } catch(Exception e) {
            e.printStackTrace();
        }

        int row = number / 3;
        int column = number % 3;

        input1.setText("행 인덱스 : " + row);
        input2.setText("열 인덱스 : " + column);
    }

    public void onCloseButtonClicked(View v) {
        finish();
    }

}
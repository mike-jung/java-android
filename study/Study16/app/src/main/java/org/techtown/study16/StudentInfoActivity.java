package org.techtown.study16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentInfoActivity extends AppCompatActivity {

    TextView output1;
    TextView output2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);

        Intent intent = getIntent();
        processIntent(intent);

    }

    private void processIntent(Intent intent) {
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");

        output1.setText(name);
        output2.setText(age);
    }

    public void onBackButtonClicked(View v) {
        finish();
    }

}
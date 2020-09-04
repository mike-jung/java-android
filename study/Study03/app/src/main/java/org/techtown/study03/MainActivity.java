package org.techtown.study03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v) {
        Toast.makeText(this, "저장 버튼이 클릭되었습니다.", Toast.LENGTH_LONG).show();
    }

    public void onButton2Clicked(View v) {
        Toast.makeText(this, "닫기 버튼이 클릭되었습니다.", Toast.LENGTH_LONG).show();
    }

}
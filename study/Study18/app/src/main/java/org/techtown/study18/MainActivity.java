package org.techtown.study18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout1;
    RelativeLayout layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = (RelativeLayout) findViewById(R.id.layout1);
        layout2 = (RelativeLayout) findViewById(R.id.layout2);

    }

    public void onTabButton1Clicked(View v) {
        layout1.setVisibility(View.VISIBLE);
        layout2.setVisibility(View.GONE);
    }

    public void onTabButton2Clicked(View v) {
        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.VISIBLE);
    }

}
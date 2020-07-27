package org.techtown.memo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        MemoInputActivity.class);
                intent.putExtra("mode", "create");
                startActivityForResult(intent, 101);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), PasswordSettingActivity.class);
                //startActivityForResult(intent, 102);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult() 호출됨 : " + requestCode + ", " + resultCode);
        if (requestCode == 101) {
            String mode = data.getStringExtra("mode");
            String contents = data.getStringExtra("contents");
            String friendName = data.getStringExtra("friendName");
            String friendMobile = data.getStringExtra("friendMobile");

            Toast.makeText(getApplicationContext(),"mode : " + mode
                    + "contents : " + contents
                    + "friendName : " + friendName
                    + "friendMobile : " + friendMobile, Toast.LENGTH_LONG).show();
        }
    }
}

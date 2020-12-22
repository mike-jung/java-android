package org.techtown.hello;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }

        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("tel:01077881234"));
                startActivity(intent);
            }

        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                User.loginName = "김하늘";

                Intent myIntent = new Intent(getApplicationContext(), NewActivity.class);
                myIntent.putExtra("loginName", "김준수");
                startActivityForResult(myIntent, User.REQ_CODE_PHONEBOOK);
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == User.REQ_CODE_PHONEBOOK) {
            if (resultCode == User.RES_CODE_SUCCESS) {
                if (data != null) {
                    String outName = data.getStringExtra("name");
                    Toast.makeText(getApplicationContext(),
                            "전달받은 name 속성의 값 : " + outName,
                            Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(getApplicationContext(),
                        "실패하였습니다.",
                        Toast.LENGTH_LONG).show();
            }
        }

    }
}

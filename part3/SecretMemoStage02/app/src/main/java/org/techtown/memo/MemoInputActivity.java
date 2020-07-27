package org.techtown.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MemoInputActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;

    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_input);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String contents = editText.getText().toString();
                String friendName = editText2.getText().toString();
                String friendMobile = editText3.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("mode", mode);
                intent.putExtra("contents", contents);
                intent.putExtra("friendName", friendName);
                intent.putExtra("friendMobile", friendMobile);

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            mode = intent.getStringExtra("mode");
        }

    }
}

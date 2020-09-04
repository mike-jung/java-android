package org.techtown.study22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SongInfoActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        Button closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void saveData() {
        String name = input1.getText().toString();
        String singer = input2.getText().toString();

        Intent dataIntent = new Intent();
        dataIntent.putExtra("name", name);
        dataIntent.putExtra("singer", singer);
        setResult(101, dataIntent);

        finish();
    }

}
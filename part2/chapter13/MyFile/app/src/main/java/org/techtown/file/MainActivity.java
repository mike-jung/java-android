package org.techtown.file;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.editTextTextPersonName2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = editText.getText().toString();
                String contents = editText2.getText().toString();

                writeToFile(filename, contents);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = editText.getText().toString();

                String contents = readFromFile(filename);
                editText2.setText(contents);
            }
        });

    }

    public void writeToFile(String filename, String contents) {
        try {
            FileOutputStream outstream = openFileOutput(filename, MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(outstream);
            writer.write(contents);

            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readFromFile(String filename) {
        String output = null;
        try {
            FileInputStream instream = openFileInput(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(instream));

            StringBuffer StrBuf = new StringBuffer();
            String aLine = "";
            while((aLine = reader.readLine()) != null) {
                StrBuf.append(aLine + "\n");
            }

            output = StrBuf.toString();

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output;
    }

}

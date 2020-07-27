package org.techtown.memo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

import java.io.File;
import java.util.Date;

public class MemoInputActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    EditText editText2;
    EditText editText3;

    String mode;

    ImageView imageView;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_input);

        textView = findViewById(R.id.textView);
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

                if (file != null) {
                    intent.putExtra("filePath", file.getAbsolutePath());
                }

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String friendMobile = editText3.getText().toString();

                try {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + friendMobile));
                    startActivity(intent);
                } catch(SecurityException e) {
                    e.printStackTrace();
                }
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String friendMobile = editText3.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + Uri.encode(friendMobile)));
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            mode = intent.getStringExtra("mode");

            if (mode != null) {
                if (mode.equals("create")) {
                    textView.setText("새 메모");

                } else if (mode.equals("modify")) {
                    String contents = intent.getStringExtra("contents");
                    String friendName = intent.getStringExtra("friendName");
                    String friendMobile = intent.getStringExtra("friendMobile");
                    String filePath = intent.getParcelableExtra("filePath");

                    textView.setText("메모 수정");

                    editText.setText(contents);
                    editText2.setText(friendName);
                    editText3.setText(friendMobile);

                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 8;
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);

                    imageView.setImageBitmap(bitmap);
                }
            }

        }

    }

    public void takePicture() {
        if (file == null) {
            file = createFile();
        }

        Uri fileUri = FileProvider.getUriForFile(this,"org.techtown.memo.fileprovider", file);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION|Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 101);
        }
    }

    int order = 0;
    private File createFile() {
        order += 1;
        String filename = "capture" + order + ".jpg";
        File storageDir = Environment.getExternalStorageDirectory();
        File outFile = new File(storageDir, filename);

        return outFile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 && resultCode == RESULT_OK) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);

            imageView.setImageBitmap(bitmap);
        }
    }

}

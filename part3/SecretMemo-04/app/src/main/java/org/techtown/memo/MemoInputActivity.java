package org.techtown.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import java.io.File;

public class MemoInputActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    TextView textView;

    String mode;

    ImageView imageView;
    File file;
    Uri fileUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_input);

        editText = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.editTextTextPersonName2);
        editText3 = findViewById(R.id.editTextTextPersonName3);
        textView = findViewById(R.id.textView);

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
                intent.putExtra("filePath", fileUri.toString());

                setResult(Activity.RESULT_OK, intent);
                finish();
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

                    try {
                        Uri imageUri = Uri.parse(filePath);
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        imageView.setImageBitmap(bitmap);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });

        // 위험권한 부여 요청
        AndPermission.with(this)
                .runtime()
                .permission(Permission.READ_EXTERNAL_STORAGE,Permission.WRITE_EXTERNAL_STORAGE,Permission.CALL_PHONE)
                .onGranted(permissions -> {
                    Log.d("Log", "허용된 권한 갯수 : " + permissions.size());
                })
                .onDenied(permissions -> {
                    Log.d("Log", "거부된 권한 갯수 : " + permissions.size());
                })
                .start();

    }

    public void takePicture() {
        Log.d("Main", "takePicture called.");

        file = createFile();

        if(Build.VERSION.SDK_INT >= 24) {
            fileUri =FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID, file);
        } else {
            fileUri = Uri.fromFile(file);
        }
        Log.d("Main", "fileUri : " + fileUri);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION|Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(intent, 101);
    }

    int order = 0;
    private File createFile() {
        order += 1;
        String filename = "capture" + order + ".jpg";
        File outFile = new File(getFilesDir(), filename);

        return outFile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(fileUri));
                    imageView.setImageBitmap(bitmap);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
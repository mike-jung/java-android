package org.techtown.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements MemoAdapter.OnItemClickListener {
    private static final String TAG = "MainActivity";

    MemoAdapter adapter;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MemoAdapter(this);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(this);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MemoInputActivity.class);
                intent.putExtra("mode", "create");
                startActivityForResult(intent, 101);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PasswordSettingActivity.class);
                startActivityForResult(intent, 102);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult() 호출됨: " + requestCode + ", " + resultCode);
        if (requestCode == 101) {
            String mode = data.getStringExtra("mode");
            String contents = data.getStringExtra("contents");
            String friendName = data.getStringExtra("friendName");
            String friendMobile = data.getStringExtra("friendMobile");
            String filePath = data.getStringExtra("filePath");

            Toast.makeText(getApplicationContext(),"mode : " + mode
                    + "contents : " + contents
                    + "friendName : " + friendName
                    + "friendMobile : " + friendMobile
                    + "filePath : " + filePath, Toast.LENGTH_LONG).show();

            if (mode != null && mode.equals("create")) {
                String timestamp = dateFormat.format(new Date());

                MemoItem item = new MemoItem(contents, friendName, friendMobile, timestamp, filePath);
                adapter.addItem(item);
                adapter.notifyDataSetChanged();
            }

        }

    }

    @Override
    public void onItemClick(int position) {
        MemoItem item = adapter.getItem(position);

        Toast.makeText(getApplicationContext(), "Item #" + position + " 클릭됨.", Toast.LENGTH_LONG).show();

        String contents = item.getContents();
        String friendName = item.getFriendName();
        String friendMobile = item.getFriendMobile();
        String filePath = item.getImagePath();

        Intent intent = new Intent(getApplicationContext(), MemoInputActivity.class);
        intent.putExtra("mode", "modify");
        intent.putExtra("contents", contents);
        intent.putExtra("friendName", friendName);
        intent.putExtra("friendMobile", friendMobile);
        intent.putExtra("filePath", filePath);
        startActivityForResult(intent, 101);
    }

}
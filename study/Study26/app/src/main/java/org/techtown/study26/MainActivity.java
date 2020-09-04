package org.techtown.study26;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        adapter = new SongAdapter();

        adapter.addItem(new Song("돌아와요 부산항에", "조용필 ", R.drawable.song));
        adapter.addItem(new Song("만남", "노사연", R.drawable.song));
        adapter.addItem(new Song("바다가 육지라면", "조미미", R.drawable.song));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnSongItemClickListener() {
            @Override
            public void onItemClick(SongAdapter.ViewHolder holder, View view, int position) {
            Song item = adapter.getItem(position);

            Toast.makeText(getApplicationContext(), "아이템 선택됨 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SongInfoActivity.class);
                startActivityForResult(intent, 101);
            }
        });

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeToFile();
            }
        });

        Button loadButton = findViewById(R.id.loadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readFromFile();
            }
        });

    }


    private void readFromFile() {
        File file = getFile();

        try {
            ObjectInputStream instream = new ObjectInputStream(new FileInputStream(file));

            ArrayList<Song> items = new ArrayList<Song>();
            Integer countObj = (Integer) instream.readObject();
            int count = countObj.intValue();

            adapter.items.clear();
            for (int i = 0; i < count; i++) {
                Song curItem = (Song) instream.readObject();
                adapter.addItem(curItem);
            }

            instream.close();

            adapter.notifyDataSetChanged();

        } catch(Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), "파일 읽기가 완료되었습니다.", Toast.LENGTH_LONG).show();
    }


    private void writeToFile() {
        File file = getFile();

        try {
            ObjectOutputStream outstream = new ObjectOutputStream(new FileOutputStream(file));

            ArrayList<Song> items = adapter.items;
            outstream.writeObject(new Integer(items.size()));
            for (int i = 0; i < items.size(); i++) {
                Song curItem = items.get(i);
                outstream.writeObject(curItem);
            }

            outstream.flush();
            outstream.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), "파일 쓰기가 완료되었습니다.", Toast.LENGTH_LONG).show();
    }

    private File getFile() {
        File folder = getFilesDir();
        File file = new File(folder, "list.txt");

        return file;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            String name = data.getStringExtra("name");
            String singer = data.getStringExtra("singer");
            int imageId = data.getIntExtra("imageId", R.drawable.song);

            Song item = new Song(name, singer, imageId);
            adapter.addItem(item);
            adapter.notifyDataSetChanged();
        }

    }

}
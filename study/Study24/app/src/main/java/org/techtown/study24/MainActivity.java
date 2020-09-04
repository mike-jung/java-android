package org.techtown.study24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
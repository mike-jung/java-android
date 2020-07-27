package org.techtown.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter adapter = new MyAdapter();

        adapter.addItem(new Person("홍길동1", "010-1000-1000"));
        adapter.addItem(new Person("홍길동2", "010-2000-2000"));
        adapter.addItem(new Person("홍길동3", "010-3000-3000"));
        adapter.addItem(new Person("홍길동4", "010-4000-4000"));
        adapter.addItem(new Person("홍길동5", "010-5000-5000"));

        recyclerView.setAdapter(adapter);

    }
}

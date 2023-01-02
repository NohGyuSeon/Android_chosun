package com.example.my_recycle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        PersonAdapter adapter = new PersonAdapter();

        adapter.addItem(new Person("김민수", "010-1000-1000", "20182333"));
        adapter.addItem(new Person("김하늘", "010-2000-2000", "20182334"));
        adapter.addItem(new Person("홍길동", "010-3000-3000", "20182335"));
        adapter.addItem(new Person("정현숙", "010-1234-7777", "20182336"));
        adapter.addItem(new Person("노규선", "010-3000-3000", "20182337"));

        recyclerView.setAdapter(adapter);
    }
}

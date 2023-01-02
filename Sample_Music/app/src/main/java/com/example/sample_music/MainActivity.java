package com.example.sample_music;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // add hyun
    private static final String TAG = "MusicService";
    Button start, stop;
    Button start2, stop2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add hyun
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);

        start2 = (Button) findViewById(R.id.start2);
        stop2 = (Button) findViewById(R.id.stop2);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        start2.setOnClickListener(this);
        stop2.setOnClickListener(this);

        //add hyun

    }

    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.start:
                Log.d(TAG, "onClick() start ");
                startService(new Intent(this, MusicService.class));
                break;
            case R.id.stop:
                Log.d(TAG, "onClick() stop");
                stopService(new Intent(this, MusicService.class));
                break;
            case R.id.start2:
                Log.d(TAG, "onClick() start ");
                startService(new Intent(this, MusicService.class));
                break;
            case R.id.stop2:
                Log.d(TAG, "onClick() stop");
                stopService(new Intent(this, MusicService.class));
                break;
        }
    }
}


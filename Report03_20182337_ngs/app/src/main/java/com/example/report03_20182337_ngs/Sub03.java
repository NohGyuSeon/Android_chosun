package com.example.report03_20182337_ngs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class Sub03 extends AppCompatActivity implements View.OnClickListener {
    public static final int SUB03_TO_MAIN = 103;
    public static final String AUDIO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_audio.amr";

    private static final String TAG = "MusicService";
    Button start, stop;

    MediaPlayer player;
    int position = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub03);

        Button btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("name", "sub03");
                setResult(SUB03_TO_MAIN, intent);
                finish();
            }
        });

        // 첫 번째 버튼 클릭 시
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                playAudio(AUDIO_URL);
            }
        });

        // 두 번째 버튼 클릭 시
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stopAudio(AUDIO_URL);
            }
        });

        // 세 번째 버튼 클릭 시
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pauseAudio(AUDIO_URL);
            }
        });

        // 네 번째 버튼 클릭 시
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                resumeAudio(AUDIO_URL);
            }
        });

        // 음악 서비스 버튼 참조
        start = (Button) findViewById(R.id.button5);
        stop = (Button) findViewById(R.id.button6);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    public void playAudio(String url) {
        showToast("음악 파일 재생 호출됨");

        killPlayer();

        player = new MediaPlayer();
        try {
            player.setDataSource(url);
            player.prepare();
            player.start();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void killPlayer() {
        if (player != null) {
            try {
                player.release();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopAudio(String url) {
        showToast("음악 파일 재생 중지됨");

        if (player != null) {
            try {
                player.stop();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pauseAudio(String url) {
        showToast("음악 파일 재생 일시정지됨");

        if (player != null) {
            try {
                position = player.getCurrentPosition();
                player.pause();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void resumeAudio(String url) {
        showToast("음악 파일 재시작됨");

        if (player != null && !player.isPlaying()) { // 일시정지 상태임을 추가로 확인
            try {
                position = player.getCurrentPosition();
                player.start();
                player.seekTo(position);
                // 일시정지 했던 시점을 찾아서 재시작
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // 음악 서비스 버튼 클릭 시 기능 구현
    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.button5:
                Log.d(TAG, "onClick() start ");
                startService(new Intent(this, MusicService.class));
                break;
            case R.id.button6:
                Log.d(TAG, "onClick() stop");
                stopService(new Intent(this, MusicService.class));
                break;
        }
    }
    
}
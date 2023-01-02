package com.example.report03_20182337_ngs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Sub04 extends YouTubeBaseActivity {
    public static final int SUB04_TO_MAIN = 104;
    private static String API_KEY = "AIzaSyCS5mOu4q5UTVAC6VeMARlIxludxQHCwVQ";
    private static String videoId = "ui2-JOTL4lA";

    YouTubePlayerView playerView;
    YouTubePlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub04);

        Button btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("name", "sub04");
                setResult(SUB04_TO_MAIN, intent);
                finish();
            }
        });

        initPlayer();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopVideo();
            }
        });
    }

    public void initPlayer() {
        playerView = findViewById(R.id.playerView);

        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                player = youTubePlayer;

                player.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                    @Override
                    public void onLoading() {}

                    @Override
                    public void onLoaded(String id) {
                        Log.d("PlayerView", "onLoaded 호출됨: " + id);

                        player.play();
                    }

                    @Override
                    public void onAdStarted() {}

                    @Override
                    public void onVideoStarted() {}

                    @Override
                    public void onVideoEnded() {}

                    @Override
                    public void onError(YouTubePlayer.ErrorReason errorReason) {}
                });

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }

        });
    }

    public void playVideo() {
        if (player != null) {
            if (player.isPlaying()) {
                player.pause();
            }

            player.cueVideo(videoId);
        }
    }

    public void stopVideo() {
        if (player != null) {
            if (player.isPlaying()) {
                player.pause();
            }

        }
    }

}
package com.example.sample_music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MusicService extends Service {
    //add hyun
    private static final String TAG = "MusicService";
    MediaPlayer player;

//    public MusicService(MediaPlayer player) {
//        this.player = player;
//    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //add hyun
        Toast.makeText(this, "Music Service媛 ?쒖옉?섏뿀?듬땲??", Toast.LENGTH_LONG)
                .show();
        Log.d(TAG, "onStart()");
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    //update hyun
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw null;
    }

    @Override
    public void onCreate() {
        //super.onCreate();
        //add hyun
        Log.d(TAG, "onCreate()");

        player = MediaPlayer.create(this, R.raw.old_pop);
        player.setLooping(false); // Set looping

    }

    @Override
    public void onDestroy() {
        //  super.onDestroy();
        //add hyun
        Toast.makeText(this, "Music Service媛 以묒??섏뿀?듬땲??", Toast.LENGTH_LONG)
                .show();
        Log.d(TAG, "onDestroy()");
        player.stop();



    }
}
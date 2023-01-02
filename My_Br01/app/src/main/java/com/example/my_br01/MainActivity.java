package com.example.my_br01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 20182337 노규선
    // add ngs

    private BroadcastReceiver chargerReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add ngs
        chargerReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(getApplicationContext(), "전원이 연결되었습니다.", Toast.LENGTH_SHORT).show();
            }
        };
        registerReceiver(chargerReceiver, new IntentFilter(Intent.ACTION_POWER_CONNECTED));
    }
    // add ngs

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // add ngs
        unregisterReceiver(chargerReceiver);

    }
}

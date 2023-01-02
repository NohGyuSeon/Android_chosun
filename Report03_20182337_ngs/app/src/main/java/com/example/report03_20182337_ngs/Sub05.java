package com.example.report03_20182337_ngs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sub05 extends AppCompatActivity {
    public static final int SUB05_TO_MAIN = 105;

    EditText editText;
    TextView textView_input;
    MyReceiver myReceiver;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub05);

        Button btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("name", "sub05");
                setResult(SUB05_TO_MAIN, intent);
                finish();
            }
        });

        editText = findViewById(R.id.editTextTextPersonName);
        textView_input = findViewById(R.id.textView_input);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                intent.putExtra("name", name);
                intent.putExtra("command", "메인 시작\n");
                startService(intent);
            }
        });

        myReceiver = new MyReceiver();
        IntentFilter filter = new IntentFilter("com.example.app7.myAction");
        this.registerReceiver(myReceiver, filter);

        NewActivity(getIntent());
    }

    private void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", editText.getText().toString());
        editor.commit();
    }

    public void NewActivity(Intent intent) {
        String name = intent.getStringExtra("name");
        String command = intent.getStringExtra("command");
        if (name != null) {
            textView_input.setText("내용: " + name + "\n경로: " + command + "다시 메인으로");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();

        restoreState();
    }

    private void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ( (pref != null) && (pref.contains("name")) ) {
            name = pref.getString("name", "");
            editText.setText(name);
        }
    }

    public class MyReceiver extends BroadcastReceiver {
        public static final String TAG = "MyReceiver";
        public Intent BroadcastIntent;

        @Override
        public void onReceive(Context context, Intent intent) {
            String name = intent.getStringExtra("name");
            String command = intent.getStringExtra("command") + "브로드캐스트 거침\n";
            Log.d(TAG, "BroadCast에서 받은 문자: " + name);
            textView_input.setText("내용: " + name + "\n" + "경로: " + command + "다시 메인으로");
            //sendToActivity(context, name, command);
        }

        // 아래 메서드를 사용하면 새 액티비티 창을 띄워서 인텐트 전송 가능
        public void sendToActivity(Context context, String name, String command) {
            BroadcastIntent = new Intent(context.getApplicationContext(), MainActivity.class);
            BroadcastIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            BroadcastIntent.putExtra("name", name);
            BroadcastIntent.putExtra("command", command);
            context.getApplicationContext().startActivity(BroadcastIntent);
        }
    }

}
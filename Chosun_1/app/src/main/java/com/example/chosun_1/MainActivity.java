package com.example.chosun_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_Clicked(View view) {
        Toast.makeText(this, "확인1 버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
    }

    public void btn_Clicked2(View view) {
        Toast.makeText(this, "네이버에 접속합니다.", Toast.LENGTH_LONG).show();
        Intent MyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(MyIntent);
    }

    public void btn_Clicked3(View view) {
        Toast.makeText(this, "전화걸기 화면으로 이동합니다.", Toast.LENGTH_LONG).show();
        Intent MyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1000-1000"));
        startActivity(MyIntent);
    }

    public void btn_Clicked4(View view) {
        Toast.makeText(this, "나에게 전화를 겁니다.", Toast.LENGTH_LONG).show();
        Intent MyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-2310-2927"));
        startActivity(MyIntent);
    }
}
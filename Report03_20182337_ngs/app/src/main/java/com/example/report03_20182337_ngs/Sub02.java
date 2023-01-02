package com.example.report03_20182337_ngs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Sub02 extends AppCompatActivity {
    public static final int SUB02_TO_MAIN = 102;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub02);

        Button btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("name", "sub02");
                setResult(SUB02_TO_MAIN, intent);
                finish();
            }
        });

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(), "학교 탭이 선택되었습니다.", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, fragment1).commit();

                        return true;
                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(), "학과 탭이 선택되었습니다.", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, fragment2).commit();

                        return true;
                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(), "진로 탭이 선택되었습니다.", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, fragment3).commit();

                    case R.id.tab4:
                        Toast.makeText(getApplicationContext(), "나의소개 탭이 선택되었습니다.", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, fragment4).commit();

                        return true;
                }

                return false;
            }
        });
    }

}
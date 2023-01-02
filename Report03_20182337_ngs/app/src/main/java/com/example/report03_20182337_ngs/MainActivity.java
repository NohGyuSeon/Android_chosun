package com.example.report03_20182337_ngs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int SUB01_TO_MAIN = 101;
    public static final int SUB02_TO_MAIN = 102;
    public static final int SUB03_TO_MAIN = 103;
    public static final int SUB04_TO_MAIN = 104;
    public static final int SUB05_TO_MAIN = 105;
    public static final int MAIN_TO_SUB01 = 111;
    public static final int MAIN_TO_SUB02 = 112;
    public static final int MAIN_TO_SUB03 = 113;
    public static final int MAIN_TO_SUB04 = 114;
    public static final int MAIN_TO_SUB05 = 115;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MAIN_TO_SUB01) {
            println("onActivityResult 메서드 호출 (Sub01 → 메인화면)\n요청 코드 : " +
                    requestCode + "\n응답 코드 : " + resultCode);
        } else if (requestCode == MAIN_TO_SUB02) {
            println("onActivityResult 메서드 호출 (Sub02 → 메인화면)\n요청 코드 : " +
                    requestCode + "\n응답 코드 : " + resultCode);
        } else if (requestCode == MAIN_TO_SUB03) {
            println("onActivityResult 메서드 호출 (Sub03 → 메인화면)\n요청 코드 : " +
                    requestCode + "\n응답 코드 : " + resultCode);
        } else if (requestCode == MAIN_TO_SUB04) {
            println("onActivityResult 메서드 호출 (Sub04 → 메인화면)\n요청 코드 : " +
                    requestCode + "\n응답 코드 : " + resultCode);
        } else if (requestCode == MAIN_TO_SUB05) {
            println("onActivityResult 메서드 호출 (Sub05 → 메인화면)\n요청 코드 : " +
                    requestCode + "\n응답 코드 : " + resultCode);
        }

        String name = data.getStringExtra("name");

        if (resultCode == SUB01_TO_MAIN) {
            println("응답으로 전달된 name : " + name +
                    "\nSub01 → 메인");
        } else  if (resultCode == SUB02_TO_MAIN) {
            println("응답으로 전달된 name : " + name +
                    "\nSub02 → 메인");
        } else  if (resultCode == SUB03_TO_MAIN) {
            println("응답으로 전달된 name : " + name +
                    "\nSub03 → 메인");
        } else  if (resultCode == SUB04_TO_MAIN) {
            println("응답으로 전달된 name : " + name +
                    "\nSub04 → 메인");
        } else  if (resultCode == SUB05_TO_MAIN) {
            println("응답으로 전달된 name : " + name +
                    "\nSub05 → 메인");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Sub01.class);
                startActivityForResult(intent, MAIN_TO_SUB01);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Sub02.class);
                startActivityForResult(intent, MAIN_TO_SUB02);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Sub03.class);
                startActivityForResult(intent, MAIN_TO_SUB03);
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Sub04.class);
                startActivityForResult(intent, MAIN_TO_SUB04);
            }
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Sub05.class);
                startActivityForResult(intent, MAIN_TO_SUB05);
            }
        });

    }

    public void println(String data) {

        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap;

    int imageindex1 = 0;
    int imageindex2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 레이아웃에 정의된 뷰 객체 참조
        scrollView = findViewById(R.id.scroll2); // 수직 방향 스크롤 뷰
        imageView = findViewById(R.id.imageView); // 이미지 뷰

        // 수평/수직 스크롤 바 사용 가능하도록 설정.
        scrollView.setHorizontalScrollBarEnabled(true);
        scrollView.setVerticalScrollBarEnabled(true);

        // 리소스의 이미지 참조
        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);

        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        // 이미지뷰의 크기 설정
        imageView.setImageDrawable(bitmap);
        // 이미지뷰의 크기를 지정하지 않을 시 이미지가 자동으로 축소됨.
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }

    public void onButton1Clicked(View view) {
        changeImage1();
    }

    public void onButton2Clicked(View view) {
        changeImage2();
    }

    // 다른 이미지 리소스로 변경
    public void changeImage1() {
        if (imageindex1 == 0) {

            Resources res = getResources();
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
            int bitmapWidth = bitmap.getIntrinsicWidth();
            int bitmapHeight = bitmap.getIntrinsicHeight();

            // 이미지 뷰를 새로운 이미지로 세팅
            imageView.setImageDrawable(bitmap);
            // 이미지 뷰의 크기를 지정하지 않을 시 이미지가 자동으로 축소됨.
            imageView.getLayoutParams().width = bitmapWidth;
            imageView.getLayoutParams().height = bitmapHeight;

            imageindex1 = 1;

        } else if (imageindex1 == 1) {

            Resources res = getResources();
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);
            int bitmapWidth = bitmap.getIntrinsicWidth();
            int bitmapHeight = bitmap.getIntrinsicHeight();

            // 이미지 뷰를 새로운 이미지로 세팅
            imageView.setImageDrawable(bitmap);
            // 이미지 뷰의 크기를 지정하지 않을 시 이미지가 자동으로 축소됨.
            imageView.getLayoutParams().width = bitmapWidth;
            imageView.getLayoutParams().height = bitmapHeight;

            imageindex1 = 0;

        }
    }

    public void changeImage2() {
        if (imageindex2 == 0) {

            Resources res = getResources();
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
            int bitmapWidth = bitmap.getIntrinsicWidth();
            int bitmapHeight = bitmap.getIntrinsicHeight();

            // 이미지 뷰를 새로운 이미지로 세팅
            imageView.setImageDrawable(bitmap);
            // 이미지 뷰의 크기를 지정하지 않을 시 이미지가 자동으로 축소됨.
            imageView.getLayoutParams().width = bitmapWidth;
            imageView.getLayoutParams().height = bitmapHeight;

            imageindex2 = 1;
        } else  if (imageindex2 == 1) {

            Resources res = getResources();
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image03);
            int bitmapWidth = bitmap.getIntrinsicWidth();
            int bitmapHeight = bitmap.getIntrinsicHeight();

            // 이미지 뷰를 새로운 이미지로 세팅
            imageView.setImageDrawable(bitmap);
            // 이미지 뷰의 크기를 지정하지 않을 시 이미지가 자동으로 축소됨.
            imageView.getLayoutParams().width = bitmapWidth;
            imageView.getLayoutParams().height = bitmapHeight;

            imageindex2 = 0;
        }
    }

}
package com.example.myframelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // MyFrameLayout 프로젝트에서 발생한 문제 해결
    /*
    sample data 이미지를 이미지뷰에 넣었을 때, 실행 시 보이지 않는 문제가 발생합니다.
    이는 두 개의 이미지가 tools 관련 속성인데 tools는 namespace이며 desing-time (디자인 타임)
    속성임을 알아냈습니다. → 실제로 앱이 build 될 때 빌드 툴이 tools 관련 속성을 제거하여 APK 사이즈나
    실행되는 앱에 영향을 주지 않는다고 합니다.
    이 때문에 안드로이드 내에서 sample 이미지들에 대한 경로를 찾아서 직접 drawable 폴더에 추가하였습니다.
    이로써 sample 이미지를 복사해온 실제 이미지로 바꾸어 앱을 실행했을 때 정상적으로 나타낼 수 있습니다.
     */

    ImageView imageView;
    ImageView imageView2;

    int imageindex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView3);
        imageView2 = (ImageView) findViewById(R.id.imageView4);
    }

    public void onButton1Clicked(View view) {
        changeImage();
    }

    public void changeImage() {
        if (imageindex == 0) {
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);

            imageindex = 1;
        } else if (imageindex == 1) {
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);

            imageindex = 0;
        }
    }
}
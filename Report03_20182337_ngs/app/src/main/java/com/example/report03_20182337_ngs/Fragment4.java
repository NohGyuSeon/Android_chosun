package com.example.report03_20182337_ngs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Fragment4 extends Fragment {
    WebView web_blog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment4, container, false);

        // 웹뷰 관련 참조 및 기능 추가
        web_blog = rootView.findViewById(R.id.web_blog);

        WebSettings webSettings2 = web_blog.getSettings();
        webSettings2.setJavaScriptEnabled(true);

        web_blog.setWebViewClient(new WebViewClient());

        web_blog.loadUrl("https://blog.naver.com/kusun1020");

        return rootView;
    }

}

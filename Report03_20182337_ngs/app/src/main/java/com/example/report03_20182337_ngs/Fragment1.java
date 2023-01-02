package com.example.report03_20182337_ngs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    WebView web_chosun;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        // 웹뷰 관련 참조 및 기능 추가
        web_chosun = rootView.findViewById(R.id.web_chosun);

        WebSettings webSettings1 = web_chosun.getSettings();
        webSettings1.setJavaScriptEnabled(true);

        web_chosun.setWebViewClient(new WebViewClient());

        web_chosun.loadUrl("https://www3.chosun.ac.kr/sites/chosun/index.do");

        return rootView;
    }

}

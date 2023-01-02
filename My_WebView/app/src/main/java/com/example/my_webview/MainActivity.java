package com.example.my_webview;

import android.os.Bundle;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //webView.setWebChromeClient(new BrowserClient());
        webView.setWebViewClient(new ViewClient());

        //webView.addJavascriptInterface(new JavaScriptMethods(), "sample");
        //webView.loadUrl("file:///android_asset/www/sample.html");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webView.loadUrl(editText.getText().toString());
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webView.loadUrl("https://www.naver.com/");
            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webView.loadUrl("https://www3.chosun.ac.kr/sites/chosun/index.do");
            }
        });
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webView.loadUrl("https://www.google.co.kr/");
            }
        });
    }

    final class BrowserClient extends WebChromeClient {
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            result.confirm();

            return true;
        }
    }

    private class ViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
            view.loadUrl(url);

            return true;
        }
    }

}

package com.example.Fragment;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.fragment.R;

public class WebViewActivity extends AppCompatActivity {

   public WebView  webView;
   public ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        progressBar=(ProgressBar)findViewById(R.id.progressBarBtn);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(view.VISIBLE);
                setTitle("Loading...");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(view.GONE);
                setTitle(view.getTitle());
            }
        });

        webView.loadUrl("https://abhiandroid.com/ui/");



    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
package com.beginner.bellalee.beginnerapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by bella.lee on 8/25/17.
 */

class CustomWebViewclient extends WebViewClient {

    private static int refreshCount;
    private Context mContext;
    private long mStart;

    public CustomWebViewclient(Context context) {
        mContext = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return false;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        mStart = System.currentTimeMillis();
        refreshCount++;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        long interval = System.currentTimeMillis() - mStart;
        Toast.makeText(mContext, "Loaded this webpage [" + refreshCount + "] " +
                "times in [" + interval + "] ms", Toast.LENGTH_SHORT).show();
    }
}

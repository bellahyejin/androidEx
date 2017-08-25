package com.beginner.bellalee.beginnerapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by bella.lee on 8/25/17.
 */

class CustomChromeclient extends WebChromeClient {

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        AlertDialog dialog = new AlertDialog.Builder(view.getContext())
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do nothing
                    }
                }).create();

        dialog.show();;
        result.confirm();
        return true;
    }
}

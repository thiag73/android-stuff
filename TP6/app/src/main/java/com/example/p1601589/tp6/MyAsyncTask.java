package com.example.p1601589.tp6;

import android.os.AsyncTask;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * Created by p1601589 on 16/03/2018.
 */

public class MyAsyncTask extends AsyncTask<Object, Void, String> {

    private TextView tv;
    private WebView webView;
    private boolean isWebView;

    @Override
    protected String doInBackground(Object... params) {
        BufferedReader in;
        String chaineURL = (String) params[0];
        String response = "";

        if (params[1] instanceof TextView) {
            tv = (TextView) params[1];
            isWebView = false;
        } else {
            webView = (WebView) params[1];
            isWebView = true;
        }
        try {
            URL url = new URL(chaineURL);
            HttpURLConnection urlConnection;
            if(isWebView){
                urlConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP,
                        new InetSocketAddress("proxy.univ-lyon1.fr", 3128)));
                if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    for(int i = 0; i<24; i++) in.readLine();
                    for(int i = 0; i<10; i++){
                        response += in.readLine();
                    }
                    in.close(); // et on ferme le flux
                }
            } else {
                urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    response = in.readLine();
                    in.close(); // et on ferme le flux
                }
            }

            urlConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if(isWebView) {
            webView.loadData(result, "text/html; charset=utf-8", "UTF-8");
        } else {
            tv.setText(result);
        }
    }
}

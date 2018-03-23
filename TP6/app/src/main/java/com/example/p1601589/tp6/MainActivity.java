package com.example.p1601589.tp6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnDateHeure;
    private Button btnGoogle;
    private Button btnTextHtml;
    private Button btnMeteoUrl;
    private Button btnMeteoData;
    private TextView text;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDateHeure = (Button) findViewById(R.id.buttonDateHeure);
        btnGoogle = (Button) findViewById(R.id.buttonGoogle);
        btnTextHtml = (Button) findViewById(R.id.buttonTextHtml);
        btnMeteoUrl = (Button) findViewById(R.id.buttonMeteoUrl);
        btnMeteoData = (Button) findViewById(R.id.buttonMeteoData);
        text = (TextView) findViewById(R.id.textView);
        webView = (WebView) findViewById(R.id.webView1);

        btnDateHeure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyAsyncTask().execute("http://10.0.2.2:3402/time", text);
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("http://www.google.fr/");
                webView.setWebViewClient(new WebViewClient());
            }
        });

        btnTextHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strHtml = "<html><body><b> Ceci est un texte au format HTML</b>" +
                        "</br>qui s’affiche très simplement</body></html>";
                webView.loadData(strHtml , "text/html; charset=utf-8", "UTF-8");
            }
        });

        btnMeteoUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("http://api.meteorologic.net/forecarss?p=Lyon");
            }
        });

        btnMeteoData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //webView.loadData("data", "text/html; charset=utf-8", "UTF-8");
                new MyAsyncTask().execute("http://api.meteorologic.net/forecarss?p=Lyon", webView);
            }
        });

    }
}

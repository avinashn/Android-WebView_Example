package mycodingcorner.webviewexample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import static android.view.View.OnClickListener;


public class MainActivity extends Activity {
    public WebView wv;
    public String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv = (WebView) findViewById(R.id.webview);
        url = "http://www.mycodingcorner.tk/2016/02/android-web-view-example.html";
        Button load_url = (Button) findViewById(R.id.loadUrl);
        load_url.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                wv.setWebViewClient(new myWebViewClient());
                wv.getSettings().setJavaScriptEnabled(true);
                wv.getSettings().setLoadsImagesAutomatically(true);
                wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wv.loadUrl(url);
            }
        });


    }

    public class myWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }
    }


}

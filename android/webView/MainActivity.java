package nooby_test.com.webview_practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


    public WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.web_view);
        String url = "http://nooby.cn";
        webView.loadUrl(url);

        //允许使用js
        webView.getSettings().setJavaScriptEnabled(true);

        //设置背景颜色，0为透明
        webView.setBackgroundColor(0);

        //适配比例显示，100为不缩放，200放大一倍，50缩小一倍
        webView.setInitialScale(100);

        //触摸放大缩小,true:可缩放，false:不可
        webView.getSettings().setBuiltInZoomControls(true);

        //双击放大|缩小(还原)
        webView.getSettings().setUseWideViewPort(true);

        //阻塞网络(http|https)图片加载
        webView.getSettings().setBlockNetworkImage(false);

        //设置是否加载图片，true：加载，false：禁止
        webView.getSettings().setLoadsImagesAutomatically(true);

        //设置webView滚动条样式
        webView.getScrollBarStyle();


        //设置app滚动条
        webView.setHorizontalScrollBarEnabled(false);//水平不显示
        webView.setVerticalScrollBarEnabled(false); //垂直不显示
//        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);//滚动条在WebView内侧显示
//        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);//滚动条在WebView外侧显示

        //设置不跳出app
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrrideUrlLoading(final WebView view, final String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //支持h5，css3.。。等新属性
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    //按back键返回上一个浏览页面
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

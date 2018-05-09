package cn.fly2cloud.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.android.tflitecamerademo.CameraActivity;
import com.example.android.tflitecamerademo.R;

import cn.fly2cloud.base.BaseActivity;

/**
 * Created by Administrator on 2018/4/24.
 */

public class ActivitySearchBaike extends BaseActivity {

    private WebView wv_search_baike;
    private String jumpName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_baike);
        jumpName = (String) getIntent().getExtras().get("jumpName");
        Log.d("hzzz",jumpName);
        initView();
        initEvent();
    }

    private void initEvent() {
        wv_search_baike.getSettings().setJavaScriptEnabled(true);
        switch(jumpName){
            case "u disk":
                wv_search_baike.loadUrl("https://baike.baidu.com/item/u盘/99846");
                break;
            case "cd":
                wv_search_baike.loadUrl("https://baike.baidu.com/item/光盘/170215");
                break;
            case "drum memory":
                wv_search_baike.loadUrl("https://baike.baidu.com/item/磁鼓");
                break;
            case "floppy disk":
                wv_search_baike.loadUrl("https://baike.baidu.com/item/软盘");
                break;
            case "hard disk":
                wv_search_baike.loadUrl("https://baike.baidu.com/item/硬盘");
                break;
            case "punched card":
                wv_search_baike.loadUrl("https://baike.baidu.com/item/打孔卡");
                break;
            case "ram":
                wv_search_baike.loadUrl("https://baike.baidu.com/item/随机存取存储器/4099402?fr=aladdin&fromid=144481&fromtitle=RAM+");
                break;
            case "tape memory":
                wv_search_baike.loadUrl("https://baike.baidu.com/item/磁带");
                break;
            default:
                break;
        }
        wv_search_baike.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }

    private void initView() {
        wv_search_baike= (WebView) findViewById(R.id.wv_search_baike);
    }

    //处理返回键
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ActivitySearchBaike.this, CameraActivity.class);
        startActivity(intent);
        ActivitySearchBaike.this.finish();

    }
}

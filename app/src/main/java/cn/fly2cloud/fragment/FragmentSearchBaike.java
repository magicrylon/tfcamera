package cn.fly2cloud.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.android.tflitecamerademo.R;

/**
 * Created by Administrator on 2018/5/9.
 */

public class FragmentSearchBaike extends Fragment{

    private WebView wv_search_baike;
    private String jumpName;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_search_baike,container,false);

        initView();
        initEvent();
        return view;
    }

    public static FragmentSearchBaike newInstance() {
        return new FragmentSearchBaike();
    }

    private void initEvent() {

                wv_search_baike.getSettings().setJavaScriptEnabled(true);
                wv_search_baike.loadUrl("https://baike.baidu.com/item/u盘/99846");
                wv_search_baike.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;

                    }
                });
    }

    private void initView() {
        wv_search_baike= (WebView) view.findViewById(R.id.wv_search_baike);
    }

}

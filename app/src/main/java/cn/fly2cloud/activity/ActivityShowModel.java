package cn.fly2cloud.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.android.tflitecamerademo.R;
import com.study.xuan.gifshow.widget.stlview.callback.OnReadCallBack;
import com.study.xuan.gifshow.widget.stlview.widget.STLView;
import com.study.xuan.gifshow.widget.stlview.widget.STLViewBuilder;

import cn.fly2cloud.base.BaseActivity;

/**
 * Created by Administrator on 2018/4/27.
 */

public class ActivityShowModel extends BaseActivity {

    private STLView stl_show_model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_model);
        initView();
        initEvent();
    }

    private void initEvent() {
        stl_show_model.setOnReadCallBack(new OnReadCallBack() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onReading(int cur, int total) {
                super.onReading(cur, total);
            }

            @Override
            public void onFinish() {
                super.onFinish();
            }
        });
        STLViewBuilder.init(stl_show_model).Assets(this, "3dmodels/hdd.stl").build();
        stl_show_model.setTouch(true);
        stl_show_model.setScale(true);
        stl_show_model.setRotate(true);
        stl_show_model.setSensor(false);
    }

    private void initView() {
        stl_show_model = (STLView) findViewById(R.id.stl_show_model);
    }
}

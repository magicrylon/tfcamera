package cn.fly2cloud.activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.android.tflitecamerademo.R;

import java.util.ArrayList;
import java.util.List;

import cn.fly2cloud.adapter.TraceListAdapter;
import cn.fly2cloud.base.BaseActivity;
import cn.fly2cloud.dao.HistoryDao;
import cn.fly2cloud.db.HistoryDBHelper;
import cn.fly2cloud.model.Trace;
import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by Administrator on 2018/4/9.
 */

public class ActivityShowHistory extends BaseActivity {

    private RecyclerView rvTrace;
    private List<Trace> traceList = new ArrayList<>(10);
    private TraceListAdapter adapter;

    private HistoryDao mDao;
    private SQLiteDatabase mDatabase;
    private Trace trace = new Trace();
    private MaterialDialog mMaterialDialog = new MaterialDialog(ActivityShowHistory.this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_history);
        findView();
        initData();
        initEvent();
    }

    private void findView() {
        rvTrace = (RecyclerView) findViewById(R.id.rv_show_history);
    }

    private void initData() {

        traceList.add(new Trace("1725-1975", "打孔卡(Punch cards)"));
        traceList.add(new Trace("1846-1990s", "穿孔纸带(Punched tape)"));
        traceList.add(new Trace("1928", "磁带(Magnetic Tape)"));
        traceList.add(new Trace("1932", "磁鼓(Magnetic Drum)"));
        traceList.add(new Trace("1946", "威廉姆斯管(Williams Tube)"));
        traceList.add(new Trace("1948", "选数管(Selectron Tube)"));
        traceList.add(new Trace("1949", "延迟线存储器(Delay Line Memory)"));
        traceList.add(new Trace("1950s", "磁芯(Magnetic Core)"));
        traceList.add(new Trace("1956", "硬盘(Hard Disk)"));
        traceList.add(new Trace("1963", "音乐磁带(Music Tape)"));
        traceList.add(new Trace("1966", "动态随机存取存储器(DRAM)"));
        traceList.add(new Trace("1968", "磁扭线存储器(Twistor Memory)"));
        traceList.add(new Trace("1970", "磁泡存储器(Bubble Memory)"));
        traceList.add(new Trace("1971", "8英寸软盘(8\" Floppy)"));
        traceList.add(new Trace("1975", "5.25英寸软盘(5.25\" Floppy)"));
        traceList.add(new Trace("1980", "光盘(CD)"));
        traceList.add(new Trace("1981", "3.5英寸软盘(3.5\" Floppy)"));
        traceList.add(new Trace("1984", "光盘只读内存(CD Rom)"));
        traceList.add(new Trace("1987", "数字录音带(Digital Audio Tape)"));
        traceList.add(new Trace("1989", "数字数据存储(Digital Data Storage)"));
        traceList.add(new Trace("1990", "磁光盘(Magneto-Optical disc)"));
        traceList.add(new Trace("1992", "迷你光碟(MiniDisc)"));
        traceList.add(new Trace("1993", "数字线性带(Digital Linear Tape)"));
        traceList.add(new Trace("1994", "闪存卡(Compact Flash)"));
        traceList.add(new Trace("1994", "极碟驱动器(Zip)"));
        traceList.add(new Trace("1995", "数字化视频光盘(DVD)"));
        traceList.add(new Trace("1995", "SM卡(SmartMedia)"));
        traceList.add(new Trace("1995", "可擦写光盘(CD-RW)"));
        traceList.add(new Trace("1997", "多媒体记忆卡(Multimedia Card)"));
        traceList.add(new Trace("1999", "微硬盘(Microdrive)"));
        traceList.add(new Trace("2000", "SD卡(SD Card)"));
        traceList.add(new Trace("2002", "XD图像卡(xD-Picture Card)"));
        traceList.add(new Trace("2003", "蓝光(Blu Ray)"));
        traceList.add(new Trace("2003", "高清光盘(HD-DVD)"));
        traceList.add(new Trace("2000s", "全息数据存储(Holographic Data Storage)"));

    }

    private void initEvent(){
        mDao = new HistoryDao(ActivityShowHistory.this);
        //设置adapter
        adapter = new TraceListAdapter(this, traceList);
        adapter.setOnItemClickListener(new TraceListAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //处理历史线界面的点击事件
                trace = mDao.findByPosition(position);
                mMaterialDialog.setTitle(trace.getTime()+"  "+trace.getName())
                        .setMessage(trace.getDescri())
                        .setPositiveButton("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();
                            }
                        });

                mMaterialDialog.show();
            }

        });
        rvTrace.setLayoutManager(new LinearLayoutManager(this));
        rvTrace.setAdapter(adapter);
    }


}

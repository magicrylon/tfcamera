package cn.fly2cloud.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.tflitecamerademo.R;

import java.util.ArrayList;
import java.util.List;

import cn.fly2cloud.model.Trace;

/**
 * Created by Administrator on 2018/4/14.
 */

public class TraceListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private LayoutInflater inflater;
    private List<Trace> traceList = new ArrayList<>(1);
    private static final int TYPE_TOP = 0x0000;
    private static final int TYPE_NORMAL= 0x0001;
    private MyItemClickListener mListener;//监听器

    public TraceListAdapter(Context context, List<Trace> traceList) {
        inflater = LayoutInflater.from(context);
        this.traceList = traceList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_show_history, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder itemHolder = (ViewHolder) holder;
        if (getItemViewType(position) == TYPE_TOP) {
            // 第一行头的竖线不显示
            itemHolder.tvTopLine.setVisibility(View.INVISIBLE);
            // 字体颜色加深
            itemHolder.tvAcceptTime.setTextColor(0xff555555);
            itemHolder.tvAcceptStation.setTextColor(0xff555555);
            itemHolder.tvDot.setBackgroundResource(R.drawable.timelline_dot_first);
        } else if (getItemViewType(position) == TYPE_NORMAL) {
            itemHolder.tvTopLine.setVisibility(View.VISIBLE);
            itemHolder.tvAcceptTime.setTextColor(0xff999999);
            itemHolder.tvAcceptStation.setTextColor(0xff999999);
            itemHolder.tvDot.setBackgroundResource(R.drawable.timelline_dot_normal);
        }
        itemHolder.cv_show_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(view, position);
            }
        });
        itemHolder.bindHolder(traceList.get(position));
    }

    @Override
    public int getItemCount() {
        return traceList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TOP;
        }
        return TYPE_NORMAL;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvAcceptTime, tvAcceptStation;
        private TextView tvTopLine, tvDot;
        private CardView cv_show_history;
        View itemView;
        MyItemClickListener mListener;
        public ViewHolder(View itemView) {
            super(itemView);
            cv_show_history=itemView.findViewById(R.id.cv_show_history);
            tvAcceptTime = (TextView) itemView.findViewById(R.id.tvAcceptTime);
            tvAcceptStation = (TextView) itemView.findViewById(R.id.tvAcceptStation);
            tvTopLine = (TextView) itemView.findViewById(R.id.tvTopLine);
            tvDot = (TextView) itemView.findViewById(R.id.tvDot);
            this.itemView=itemView;
        }

        public void bindHolder(Trace trace) {
            tvAcceptTime.setTextColor(Color.BLUE);
            tvAcceptStation.setTextColor(Color.BLACK);
            tvAcceptTime.setText(trace.getTime());
            tvAcceptStation.setText(trace.getName());
            if(mListener!=null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mListener.onItemClick(view, getAdapterPosition());
                    }
                });
            }

        }
    }
    /**
     * 为Adapter暴露一个Item点击监听的公开方法
     *
     * @param listener
     */
    public void setOnItemClickListener(MyItemClickListener listener) {
        this.mListener = listener;
    }
    /**
     * 回调接口
     */
    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }
}


package com.app.liulongbing.beam.text;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.liulongbing.beam.R;
import com.app.liulongbing.beam.bean.TextJoy;
import com.app.liulongbing.beam.utils.RecentDateFormat;
import com.app.liulongbing.beam.utils.TextFilter;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.utils.JTimeTransform;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liulongbing on 16/4/28.
 */
public class TextJoyVH extends BaseViewHolder<TextJoy>{
    @Bind(R.id.content)
    TextView content;
    @Bind(R.id.time)
    TextView time;



    public TextJoyVH(ViewGroup parent) {
        super(parent, R.layout.item_joy_text);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(TextJoy data) {
        super.setData(data);
        content.setText(TextFilter.filter(data.getText()));
        time.setText(new JTimeTransform().parse("yyyy-MM-dd hh:mm:ss",data.getCt()).toString(new RecentDateFormat()));
    }
}

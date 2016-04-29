package com.app.liulongbing.beam.text;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import com.app.liulongbing.beam.bean.TextJoy;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by liulongbing on 16/4/28.
 */

@RequiresPresenter(TextJoyPresenter.class)
public class TextJoyFragment extends BeamListFragment<TextJoyPresenter,TextJoy> {

    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new TextJoyVH(parent);
    }


    @Override
    protected ListConfig getConfig() {
        return super.getConfig()
                .setLoadmoreAble(true)
                .setRefreshAble(true)
                .setNoMoreAble(true)
                .setErrorAble(true)
                .setErrorTouchToResumeAble(true);
    }

}

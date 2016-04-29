package com.app.liulongbing.beam.text;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.app.liulongbing.beam.JoyModel;
import com.app.liulongbing.beam.bean.TextJoy;
import com.app.liulongbing.beam.bean.TextJoyPage;
import com.app.liulongbing.beam.callBack.DataCallback;
import com.jude.beam.expansion.list.BeamListFragmentPresenter;

/**
 * Created by liulongbing on 16/4/28.
 */

public class TextJoyPresenter extends BeamListFragmentPresenter<TextJoyFragment,TextJoy>{
    int page=1;

    @Override
    protected void onCreate(@NonNull TextJoyFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        JoyModel.getInstance().getTextJoy(page, new DataCallback<TextJoyPage>() {
            @Override
            public void success(String info, TextJoyPage data) {
                getAdapter().clear();
                getAdapter().addAll(data.getContentlist());
                page=2;
            }

            @Override
            public void error(String errorInfo) {
                super.error(errorInfo);
                getView().showError(new Throwable(errorInfo));
            }
        });
    }

    @Override
    public void onLoadMore() {
        JoyModel.getInstance().getTextJoy(page, new DataCallback<TextJoyPage>() {
            @Override
            public void success(String info, TextJoyPage data) {
                getAdapter().addAll(data.getContentlist());
                page++;
            }
            @Override
            public void onError(String errorMsg) {
                getAdapter().pauseMore();
            }
        });
    }
}

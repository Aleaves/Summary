package com.app.liulongbing.beam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.jude.beam.bijection.Presenter;

/**
 * Created by liulongbing on 16/4/28.
 */

public class MainPresenter extends Presenter<MainActivity>{
    @Override
    protected void onCreate(@NonNull MainActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        Log.i("======","presenter===onCreate");
    }

    @Override
    protected void onCreateView(@NonNull MainActivity view) {
        super.onCreateView(view);
        Log.i("======","presenter===onCreateView");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("======","presenter===onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("======","presenter===onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("======","presenter===onDestory");
    }

    @Override
    protected void onDestroyView() {
        super.onDestroyView();
        Log.i("======","pr" +
                "esenter===onDestoryView");
    }

    @Override
    protected void onResult(int requestCode, int resultCode, Intent data) {
        super.onResult(requestCode, resultCode, data);
        Log.i("======","presenter===onResult");
    }

    @Override
    protected void onSave(Bundle state) {
        super.onSave(state);
        Log.i("======","presenter===onSave");
    }
}

package com.app.liulongbing.beam;

import android.app.Application;

import com.jude.beam.Beam;
import com.jude.http.RequestManager;
import com.jude.utils.*;
import com.jude.utils.BuildConfig;

/**
 * Created by liulongbing on 16/4/28.
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        JUtils.initialize(this);
        JUtils.setDebug(BuildConfig.DEBUG,"JoyLog");
        RequestManager.getInstance().init(this);
        RequestManager.getInstance().setDebugMode(BuildConfig.DEBUG,"JoyNet");
        Beam.init(this);
    }

}

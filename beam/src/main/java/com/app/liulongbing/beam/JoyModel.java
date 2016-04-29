package com.app.liulongbing.beam;

import android.content.Context;

import com.app.liulongbing.beam.bean.ImageJoyPage;
import com.app.liulongbing.beam.bean.TextJoy;
import com.app.liulongbing.beam.bean.TextJoyPage;
import com.app.liulongbing.beam.callBack.DataCallback;
import com.app.liulongbing.beam.config.API;
import com.jude.beam.model.AbsModel;
import com.jude.http.RequestManager;
import com.jude.http.RequestMap;

import java.util.HashMap;

/**
 * Created by liulongbing on 16/4/28.
 */

public class JoyModel extends AbsModel{

    public static JoyModel getInstance(){
        return getInstance(JoyModel.class);
    }

    @Override
    protected void onAppCreate(Context ctx) {
        super.onAppCreate(ctx);
        HashMap<String ,String > header = new HashMap<>();
        header.put("apikey"," c676a989ffe83f89db5265482ef3222d");
        RequestManager.getInstance().setHeader(header);
    }

    public void getTextJoy(int page, DataCallback<TextJoyPage> callback){
        RequestManager.getInstance().post(API.URL.JOY_TEXT,new RequestMap("page",page+""),callback);
    }

    public void getImageJoy(int page, DataCallback<ImageJoyPage> callback){
        RequestManager.getInstance().post(API.URL.JOY_IMAGE,new RequestMap("page",page+""),callback);
    }

}

package com.app.liulongbing.beam.callBack;
import com.app.liulongbing.beam.config.API;
import com.google.gson.Gson;
import com.jude.utils.JUtils;
import org.json.JSONObject;
import java.lang.reflect.ParameterizedType;
/**
 * Created by liulongbing on 16/4/28.
 */
public abstract class DataCallback<T> extends LinkCallback{
    @Override
    public void onRequest() {
        super.onRequest();
    }

    @Override
    public void onSuccess(String response) {
        JSONObject jsonObject;
        int status = 0;
        String info = "";
        T data = null;
        try {
            jsonObject = new JSONObject(response);
            status = jsonObject.getInt(API.KEY.STATUS);
            info = jsonObject.getString(API.KEY.INFO);
            if (status == API.CODE.SUCCEED){
                Gson gson = new Gson();
                data = gson.fromJson(jsonObject.getString(API.KEY.DATA), ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
            }

        }catch (Exception e){
            JUtils.Log(e.getLocalizedMessage());
            error("数据解析错误");
            return ;
        }
        result(status, info);
        if (status == API.CODE.SUCCEED){
            success(info,data);
        }else{
            error(info);
        }

        super.onSuccess(response);
    }

    @Override
    public void onError(String errorMsg) {
        result(-1,"网络错误");
        error("网络错误");
        super.onError(errorMsg);
    }

    public void result(int status, String info){}
    public abstract void success(String info,T data);
    public void error(String errorInfo){
        JUtils.Toast(errorInfo);
    }


}

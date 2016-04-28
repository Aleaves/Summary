package com.app.liulongbing.summary;

import org.json.JSONObject;

import java.util.Map;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.HEAD;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by liulongbing on 16/4/27.
 */
public interface APIService {

    @GET("stories/latest")
    Call<JSONObject> getNews();

    @Multipart
    @POST("v1.0/")
    Call<JSONObject> login(@Part("token") String token, @Part("content") String content);


    @Headers("Cookie:session_id=c3fab0b3b3370d238272002e9e18ecccb")
    @Multipart
    @POST("v1.0/")
    Call<JSONObject> getInterest(@Part("token")String token,@Part("content")String content);
}

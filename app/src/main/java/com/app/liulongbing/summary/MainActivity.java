package com.app.liulongbing.summary;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.okhttp.OkHttpClient;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * retrofit 联网框架
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNews();
            }
        });

        findViewById(R.id.bt_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


        findViewById(R.id.bt_interest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInterest();
            }
        });
    }

    private void getNews(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/api/4/")
                .addConverterFactory(JsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();

        APIService apiService=retrofit.create(APIService.class);
        Call<JSONObject> result=apiService.getNews();
        result.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Response<JSONObject> response, Retrofit retrofit) {
                Log.i("=======",response.body()+"");
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void login(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://api.cailai.com/")
                .addConverterFactory(JsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        APIService apiService=retrofit.create(APIService.class);
        String content=RestTool.getLoginParams("13917944029","123456").get(0);
        String token=RestTool.getLoginParams("13917944029","123456").get(1);

        Call<JSONObject> call=apiService.login(token,content);

        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Response<JSONObject> response, Retrofit retrofit) {
                Log.i("=======",response.headers()+"");
                Log.i("=======",response.body()+"");
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void getInterest(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://api.cailai.com/")
                .addConverterFactory(JsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        APIService apiService=retrofit.create(APIService.class);
        String content =RestTool.getInterestParams().get(0);
        String token=RestTool.getInterestParams().get(1);

        Call<JSONObject> call=apiService.getInterest(token,content);
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Response<JSONObject> response, Retrofit retrofit) {
                Log.i("=======",response.headers()+"");
                Log.i("=======",response.body()+"");
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

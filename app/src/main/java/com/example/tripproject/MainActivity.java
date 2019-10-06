package com.example.tripproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    IService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw_3);

        Stetho.initializeWithDefaults(this);
        OkHttpClient okhttpclient = new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor())
                .build();

        Retrofit retrofit =
                new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(okhttpclient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(IService.class);

        textView = findViewById(R.id.textview);
        textView = textView.setOnClickListener()

        Call<JsonObject> requestUserRepo = service.getUserRepositories("sungoukchoi");
        requestUserRepo.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

}

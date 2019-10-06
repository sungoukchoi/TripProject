package com.example.tripproject;

import android.app.Application;

import com.kakao.auth.KakaoSDK;

public class GlobalApplication extends Application {
    private static GlobalApplication instance;

    public static GlobalApplication getGlobalApplicationContext(){
        if(instance==null){
            throw new IllegalStateException("This Application does not inherit com.kakao.GlobalApplication");
        }

        return instance;
    }
    public void onCreate(){
        super.onCreate();
        instance=this;

        KakaoSDK.init(new KaKaoSDKAdapter());
    }

    public void onTerminate(){
        super.onTerminate();
        instance=null;
    }
}

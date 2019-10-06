package com.example.tripproject;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IService {

    // https://api.github.com/users/{user}/repos
    @GET("users/user}/repos")
    Call<JsonObject> getUserRepositories(@Path("user")String userName);
}

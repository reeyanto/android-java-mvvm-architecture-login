package com.melonkoding.androidmvvmarchitecture.services;

import com.melonkoding.androidmvvmarchitecture.models.requests.LoginRequest;
import com.melonkoding.androidmvvmarchitecture.models.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("/api/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}

package com.melonkoding.androidmvvmarchitecture.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.melonkoding.androidmvvmarchitecture.models.requests.LoginRequest;
import com.melonkoding.androidmvvmarchitecture.models.responses.LoginResponse;
import com.melonkoding.androidmvvmarchitecture.services.LoginService;
import com.melonkoding.androidmvvmarchitecture.services.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    private LoginService loginService;

    public LoginRepository() {
        loginService = RetrofitClient.getInstance().create(LoginService.class);
    }

    public LiveData<LoginResponse> login(LoginRequest loginRequest) {
        MutableLiveData<LoginResponse> data = new MutableLiveData<>();

        loginService.login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}

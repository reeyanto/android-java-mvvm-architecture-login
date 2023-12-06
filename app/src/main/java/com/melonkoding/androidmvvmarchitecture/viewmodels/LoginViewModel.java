package com.melonkoding.androidmvvmarchitecture.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.melonkoding.androidmvvmarchitecture.models.requests.LoginRequest;
import com.melonkoding.androidmvvmarchitecture.models.responses.LoginResponse;
import com.melonkoding.androidmvvmarchitecture.repositories.LoginRepository;

public class LoginViewModel extends ViewModel {

    private LoginRepository loginRepository;

    public LoginViewModel() {
        loginRepository = new LoginRepository();
    }

    public LiveData<LoginResponse> login(LoginRequest loginRequest) {
        return loginRepository.login(loginRequest);
    }
}

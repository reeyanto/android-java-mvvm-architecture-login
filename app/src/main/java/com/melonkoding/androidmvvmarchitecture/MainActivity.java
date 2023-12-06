package com.melonkoding.androidmvvmarchitecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.melonkoding.androidmvvmarchitecture.models.requests.LoginRequest;
import com.melonkoding.androidmvvmarchitecture.viewmodels.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.et_email);
        EditText password = findViewById(R.id.et_password);
        Button button = findViewById(R.id.btn_login);
        ProgressBar progressBar = findViewById(R.id.pb_progress);

        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        button.setOnClickListener(view -> {
            if ((email.getText().toString().trim().length() == 0) || (password.getText().toString().trim().length() == 0)) {
                Toast.makeText(this, "Please fill email and password fields first!", Toast.LENGTH_SHORT).show();
            } else {
                progressBar.setVisibility(View.VISIBLE);
                LoginRequest loginRequest = new LoginRequest(email.getText().toString(), password.getText().toString());
                loginViewModel.login(loginRequest).observe(this, loginResponse -> {
                    if (loginResponse != null) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "You're logged in with token: "+ loginResponse.getToken(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
package com.example.digitaltaste;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.textfield.TextInputEditText;

public class LogInActivity extends AppCompatActivity {
    TextView userTv;
    TextInputEditText username_login, password_login;
    Button loginBTN, registerBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userTv = findViewById(R.id.userTv);
        username_login = findViewById(R.id.username_login);
        password_login = findViewById(R.id.password_login);
        loginBTN = findViewById(R.id.loginBTN);
        registerBTN = findViewById(R.id.registerBTN);

        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE );
        String USERNAME = sharedPreferences.getString("username", "");
        String PASSWORD = sharedPreferences.getString("password", "");

        loginBTN.setOnClickListener(v ->{
            String username = username_login.getText().toString();
            String password = password_login.getText().toString();

            if (username.isEmpty()) {
                username_login.setError("Please fill this field");
            } else if (password.isEmpty()) {
                password_login.setError("Please fill this field");
            } else if (username.equals(USERNAME) && password.equals(PASSWORD)){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.apply();

                Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            } else {
                Toast.makeText(LogInActivity.this, "Username or Password wrong", Toast.LENGTH_SHORT).show();
            }
        });

        registerBTN.setOnClickListener(v -> {
            Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

    }
}

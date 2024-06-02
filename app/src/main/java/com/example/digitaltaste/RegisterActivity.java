package com.example.digitaltaste;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText username_register, password_register;
    Button regBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username_register = findViewById(R.id.username_register);
        password_register = findViewById(R.id.password_register);
        regBTN = findViewById(R.id.regBTN);

        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE );

        regBTN.setOnClickListener(v ->{
            String username = username_register.getText().toString();
            String password = password_register.getText().toString();

            if (username.isEmpty()) {
                username_register.setError("Please fill this field");
            } else if (password.isEmpty()) {
                password_register.setError("Please fill this field");
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.apply();

                Intent intent = new Intent(RegisterActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();

                Toast.makeText(RegisterActivity.this, "Account Successfully Created. Please Log in Again", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

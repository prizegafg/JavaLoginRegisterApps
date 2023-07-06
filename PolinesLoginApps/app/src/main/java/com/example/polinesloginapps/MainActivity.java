package com.example.polinesloginapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoToLogin = findViewById(R.id.btn_go_to_login);
        Button btnGoToRegister = findViewById(R.id.btn_go_to_register);

        btnGoToLogin.setOnClickListener(this);
        btnGoToRegister.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_go_to_login) {
            Intent moveIntent = new Intent(MainActivity.this, LoginView.class);
            startActivity(moveIntent);
        }else if (view.getId() == R.id.btn_go_to_register) {
            Intent navigateIntent = new Intent(MainActivity.this, RegisterView.class);
            startActivity(navigateIntent);
        }
    }

}
package com.example.polinesloginapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.prizega.polinesloginapps.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoToLogin = findViewById(R.id.btn_go_to_login);
        Button btnGoToRegister = findViewById(R.id.btn_go_to_register);

        btnGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveIntent = new Intent(MainActivity.this, LoginView.class);
                startActivity(moveIntent);
            }
        });
        btnGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navigateIntent = new Intent(MainActivity.this, RegisterView.class);
                startActivity(navigateIntent);
            }
        });



    }

}
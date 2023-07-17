package com.example.polinesloginapps;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.prizega.polinesloginapps.R;


public class LoginView extends AppCompatActivity {

    Button btnForgotPassword, btnLogin;
    ImageButton btnRememberMe, btnLoginApple, btnLoginGoogle, btnBack;
    EditText edtEmail, edtPassword;

    String userName;
    String password;
    Boolean isRemember;
    Boolean isVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        setUpButton(btnForgotPassword, R.id.btn_forgot_password_login);
        setUpButton(btnLogin, R.id.btn_sign_in_login);
        setUpImageButton(btnBack,R.id.btn_back_login);
        setUpImageButton(btnRememberMe, R.id.btn_rememberme_login);
        setUpImageButton(btnLoginApple, R.id.btn_sign_in_apple_login);
        setUpImageButton(btnLoginGoogle, R.id.btn_sign_in_google_login);

        edtEmail = findViewById(R.id.input_email_login);
        edtPassword = findViewById(R.id.input_password_login);

    }

    void setUpButton(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btn_forgot_password_login){
                    Toast.makeText(LoginView.this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show();

                } else if (view.getId() == R.id.btn_sign_in_login) {
                    userName = edtEmail.getText().toString();
                    password = edtPassword.getText().toString();

                    if (userName.isEmpty()) {
                        Toast.makeText(LoginView.this, "Please fill username", Toast.LENGTH_SHORT).show();
                    } else if (password.isEmpty()) {
                        Toast.makeText(LoginView.this, "Please fill password", Toast.LENGTH_SHORT).show();
                    } else  {
                        Toast.makeText(LoginView.this, "Success Login", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }



    void setUpImageButton(ImageButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btn_rememberme_login){
                    Toast.makeText(LoginView.this, "Remember me clicked", Toast.LENGTH_SHORT).show();
                    if (isRemember == true){
                        isRemember = false;
                        btnRememberMe.setImageResource(R.color.grey);
                    } else {
                        isRemember = true;
                        btnRememberMe.setImageResource(R.color.black);
                    }

                } else if (view.getId() == R.id.btn_sign_in_apple_login) {

                } else if (view.getId() == R.id.btn_sign_in_google_login){

                } else {

                }
            }
        });
    }




}
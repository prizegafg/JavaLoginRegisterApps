package com.example.polinesloginapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.prizega.polinesloginapps.R;

import org.checkerframework.checker.nullness.qual.NonNull;
import java.util.HashMap;
import java.util.Map;


public class RegisterView extends AppCompatActivity {
    Button btnRegister;
    ImageButton btnRegisApple, btnRegisGoogle, btnBack;
    EditText edtFirstName, edtLastName, edtUsername, edtEmail, edtPassword, edtRepeatPassword;

    String firstName;
    String lastName;
    String userName;
    String email;
    String password;
    String repeatPassword;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    //private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);

//        mAuth = FirebaseAuth.getInstance();

        btnRegister = findViewById(R.id.btn_sign_up_register);
        edtFirstName = findViewById(R.id.input_firstname_register);
        edtLastName = findViewById(R.id.input_lastname_register);
        edtUsername = findViewById(R.id.input_username_register);
        edtEmail = findViewById(R.id.input_email_register);
        edtPassword = findViewById(R.id.input_password_register);
        edtRepeatPassword = findViewById(R.id.input_repeatPassword_register);

        setUpImageButton(btnBack, R.id.btn_back_register);
        setUpImageButton(btnRegisApple, R.id.btn_sign_in_apple_regis);
        setUpImageButton(btnRegisGoogle, R.id.btn_sign_in_google_regis);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName = edtFirstName.getText().toString();
                lastName = edtLastName.getText().toString();
                userName = edtUsername.getText().toString();
                email = edtEmail.getText().toString();
                password = edtPassword.getText().toString();
                repeatPassword = edtRepeatPassword.getText().toString();

                if (firstName.isEmpty() || lastName.isEmpty() || userName.isEmpty() || email.isEmpty()
                        || password.isEmpty() || repeatPassword.isEmpty()) {
                    Toast.makeText(RegisterView.this, "Please Fill The Empty Field!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    if (password == repeatPassword) {
                        checkFirestoreData();
                    } else {
                        Toast.makeText(RegisterView.this,
                                "Password did not same, please double check",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }

    void setUpImageButton(ImageButton btn, int id) {

    }

    void checkFirestoreData(){
        addDataToFirestore();
    }

    void addDataToFirestore(){
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("FirstName", firstName);
        user.put("LastName", lastName);
        user.put("Username", userName);
        user.put("Email",email);


// Add a new document with a generated ID
        db.collection("UserData/9Y8i935dXhzxHO9CO1dn")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(RegisterView.this, "Register Success, Id :" +
                                        documentReference.getId(), Toast.LENGTH_SHORT).show();
//                        addDataToFirebaseAuth();
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterView.this, "Register failed",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

//    void addDataToFirebaseAuth(){
//
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            FirebaseUser user = mAuth.getCurrentUser();
//
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Toast.makeText(RegisterView.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//                });
//    }



}
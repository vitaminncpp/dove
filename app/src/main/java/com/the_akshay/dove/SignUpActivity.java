package com.the_akshay.dove;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.the_akshay.dove.databinding.ActivitySignUpBinding;
import com.the_akshay.dove.models.User;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sign_up);
        Toast.makeText(SignUpActivity.this, "User Created Successfully", Toast.LENGTH_LONG);
        binding = com.the_akshay.dove.databinding.ActivitySignUpBinding.inflate(getLayoutInflater());
        //binding.getName().setText(viewModel.getName());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        pDialog=new ProgressDialog(SignUpActivity.this);
        pDialog.setTitle("Creating Account");
        pDialog.setMessage("We're Creating your Account");

        binding.signupBtnSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pDialog.show();
                auth.createUserWithEmailAndPassword(binding.signupTxtEmail.getText().toString(), binding.signupTxtPwd.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        pDialog.dismiss();
                        if (task.isSuccessful()) {
                            User user=new User(binding.signupTxtUname.getText().toString(),binding.signupTxtEmail.getText().toString(),binding.signupTxtPwd.getText().toString());
                            String id =task.getResult().getUser().getUid();
                            auth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(getBaseContext(),"Verification Main has been sent",Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(getBaseContext(),"Failed to send verification Main",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            database.getReference() . child("Users") . child(id).setValue(user);
                            Toast.makeText(getBaseContext(), "User Created Successfully", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getBaseContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        binding.signupLblSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });
    }
}
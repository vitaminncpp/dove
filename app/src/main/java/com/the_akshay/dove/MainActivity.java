package com.the_akshay.dove;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.the_akshay.dove.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Toast.makeText( MainActivity.this, "MainActivity Oncreate", Toast.LENGTH_SHORT).show();
        binding=ActivityMainBinding.inflate(getLayoutInflater());

        auth=FirebaseAuth.getInstance();
        setContentView(binding.getRoot());

        binding.signin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, SignInActivity.class));
                    }
                }
        );
        binding.MainBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
                Toast.makeText(MainActivity.this,"Whalla it is working",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.settings:
                Toast.makeText(this,"Settings are not supported yet",Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                auth.signOut();
                startActivity(new Intent(MainActivity.this,SignInActivity.class));
                Toast.makeText(this,"You Signed Out SuccessFully",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
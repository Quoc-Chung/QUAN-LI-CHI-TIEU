package com.example.quanlichitieu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quanlichitieu.UI.HomeCaNhanActivity;

public class MainActivity extends AppCompatActivity {
    EditText txtEmail, txtPassword;
    Button btnSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnSignin = findViewById(R.id.btnSignin);

        btnSignin.setOnClickListener(v->{
            if(!loginSuccess()){
                Intent intent = new Intent(MainActivity.this, HomeCaNhanActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean loginSuccess() {
        return txtEmail.getText().toString().isEmpty() && txtPassword.getText().toString().isEmpty();
    }
}
package com.example.test11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    EditText username,Password,phoneNo;
    Button btnLogin;
    String bitcode,bitcode123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin.setOnClickListener(this);
        initView();


    }


    private void initView() {
        username=findViewById(R.id.username);
        Password=findViewById(R.id.Password);
        phoneNo=findViewById(R.id.phoneNo);
        btnLogin=findViewById(R.id.btnLogin);

    }
    public void onClick(View view) {
        if (username.equals(bitcode)&&Password.equals(bitcode123)){
            Intent intent = new Intent(MainActivity.this, converterActivity.class);
            intent.putExtra("username", username.getText().toString());
            intent.putExtra("phoneNo", phoneNo.getText().toString());
            startActivity(intent);
        }
        else {
            Toast.makeText(MainActivity.this, "Enter Correct Data", Toast.LENGTH_LONG).show();
        }
    }

    }

package com.example.test11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,Password,phoneNo;
    Button btnLogin;
    String bitcode,bitcode123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();

    }

    private void initListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.equals(bitcode)&&Password.equals(bitcode123)){
                    Intent intent = new Intent(MainActivity.this, converterActivity.class);
                    intent.putExtra("username", username.getText().toString());
                    intent.putExtra("phoneNo", phoneNo.getText().toString());
                    startActivityForResult(intent, 1);}
                else {
                    Toast.makeText(MainActivity.this, "Enter Correct Data", Toast.LENGTH_LONG).show();
                }
                }
        });
    }

    private void initView() {
        username=findViewById(R.id.username);
        Password=findViewById(R.id.Password);
        phoneNo=findViewById(R.id.phoneNo);

    }
}
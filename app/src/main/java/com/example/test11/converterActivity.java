package com.example.test11;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class converterActivity extends Activity implements View.OnClickListener{
    TextView txtUsername,txtPhoneNo,currentDate,currentTime;
    Button  btnCurrentDate,btnCurrentTime,btnConvert;
    EditText EnterAmount;
    Dialog dialog;
    RadioButton USA,UK,UAE,China;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converteractivity);
        initview();
        initListener();
        SetExtraData();
        converterAmountdialog();


    }



    private void SetExtraData() {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String username=bundle.getString("username");
        String phoneno=bundle.getString("phoneNo");
        txtUsername.setText(username);
        txtPhoneNo.setText(phoneno);

    }

    private void initListener() {
        btnConvert.setOnClickListener(this);
        btnCurrentTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog=new TimePickerDialog(converterActivity.this,
                        new MyonTimeSetListener(),
                        16,
                        52,
                        true);
                timePickerDialog.show();
            }
        });
        btnCurrentDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(converterActivity.this,
                        new MyOnDateSetListener(),
                        2022,12,12);
                datePickerDialog.show();

            }
        });

    }
    class  MyonTimeSetListener implements TimePickerDialog.OnTimeSetListener{

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            currentTime.setText(hourOfDay+":"+minute);
        }
    }
    class MyOnDateSetListener implements DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            currentDate.setText(year+"/"+month+"/"+dayOfMonth);
        }
    }

    private void initview() {
        txtUsername=findViewById(R.id.txtUsername);
        txtPhoneNo=findViewById(R.id.txtPhoneNo);

    }
    @Override
    public void onClick(View view) {
        if (view==btnConvert){
            dialog.show();}
    }
    private void converterAmountdialog() {
        TextView convertedAmount;
        dialog.setContentView(R.layout.convertercustomdialog);
        dialog.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        USA=dialog.findViewById(R.id.USA);
        UK=dialog.findViewById(R.id.UK);
        UAE=dialog.findViewById(R.id.UAE);
        China=dialog.findViewById(R.id.China);
        USA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    int intAmount=Intent.parseIntent(EnterAmount.getText().toString());
                convertedAmount.setText(intAmount*82);

            }
        });
        UK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intAmount=Intent.parseIntent(EnterAmount.getText().toString());
                convertedAmount.setText(intAmount*92);

            }
        });
        UAE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intAmount=Intent.parseIntent(EnterAmount.getText().toString());
                convertedAmount.setText(intAmount*92);
            }
        });
        China.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intAmount=Intent.parseIntent(EnterAmount.getText().toString());
                convertedAmount.setText(intAmount*89);
            }
        });
    }
    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.optionmenu,menu);

        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemid=item.getItemId();
        if (itemid==R.id.Logout){
            Toast.makeText(this, "Logging Out", Toast.LENGTH_LONG).show();
            Intent revintent=new Intent();
            setResult(1,revintent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

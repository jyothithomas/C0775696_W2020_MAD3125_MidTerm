package com.example.c0775696_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class PersonInfoActivity extends AppCompatActivity {

    private Button btnSubmit;
    private Button btnClear;
    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtSinNumber;
    private EditText edtSelectDate;
    private TextInputLayout edtBirthDate;
    private EditText edtGrossIncome;
    private EditText edtRRSP;
    private RadioButton rbtnMale;
    private RadioButton rbtnFemale;
    private RadioButton rbtnOther;
    @Override
    protected void onStart()
    {
        super.onStart();
        clearAllField();
    }

    private void clearAllField() {

            edtSinNumber.getText().clear();
            edtFirstName.getText().clear();
            edtLastName.getText().clear();
            //edtSelectDate.getText().clear();
           ///// edtGrossIncome.getText().clear();
           // edtRRSP.getText().clear();
           // rbtnMale.setChecked(false);
           // rbtnFemale.setChecked(false);
           // rbtnOther.setChecked(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtFirstName = findViewById(R.id.edtFirstNameText);
        edtLastName = findViewById(R.id.edtLastNameText);
        edtSinNumber = findViewById(R.id.edtSinnumber);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(PersonInfoActivity.this, DataDisplayActivity.class);
                startActivity(mIntent);
            }
        });

    }
}


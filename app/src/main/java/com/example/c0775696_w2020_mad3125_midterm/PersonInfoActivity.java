package com.example.c0775696_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PersonInfoActivity extends AppCompatActivity {

    private Button btnCalculate;
    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtSinNumber;
    private EditText edtDOB;
    private TextView edtTaxFiledDate;
    private EditText edtGrossIncome;
    private EditText edtRRSP;
    private RadioButton rbtnMale;
    private RadioButton rbtnFemale;
    private RadioButton rbtnOther;

    private   DatePickerDialog picker;
    final Calendar calendar = Calendar.getInstance();
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final   int month = calendar.get(Calendar.MONTH);
    final int year = calendar.get(Calendar.YEAR);
    String gender=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtFirstName = findViewById(R.id.txtFirstName);
        edtLastName = findViewById(R.id.txtLastName);
        edtSinNumber = findViewById(R.id.txtSinNumber);
        rbtnMale = findViewById(R.id.rdMale);
        rbtnFemale = findViewById(R.id.rdFeMale);
        rbtnOther = findViewById(R.id.rdOther);
        edtGrossIncome = findViewById(R.id.txtGrossIncome);
        edtRRSP =findViewById(R.id.txtRrsp);
        edtDOB = findViewById(R.id.txtBirthDate);
        edtTaxFiledDate = findViewById(R.id.txtTaxFillDate);


        btnCalculate = findViewById(R.id.btnCalculate);
        edtTaxFiledDate.setText(new StringBuilder()
                .append(day).append(" ").append("-").append(month + 1).append("-")
                .append(year));

        edtDOB.setInputType(InputType.TYPE_NULL);
        edtDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // date picker dialog
                picker = new DatePickerDialog(PersonInfoActivity.this,
                        new DatePickerDialog.OnDateSetListener() {


                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                edtDOB.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, year, month, day);
                picker.show();
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fieldIsEmpty();
                //Intent mIntent = new Intent(PersonInfoActivity.this, DataDisplayActivity.class);
                //startActivity(mIntent);
            }
        });

    }

    private void fieldIsEmpty() {
        boolean Flag = false;
        if(edtSinNumber.getText().toString().isEmpty())
        {
            edtSinNumber.setError("Please enter your SIN");
            Flag = true;
            return;
        }
        if(edtFirstName.getText().toString().isEmpty()){
            edtFirstName.setError("Please enter your first name");
            Flag = true;
            return;
        }
        if(edtLastName.getText().toString().isEmpty())
        {
            edtLastName.setError("Please enter your date of birth");
            Flag = true;
            return;
        }
        if(edtDOB.getText().toString().isEmpty())
        {
            edtDOB.setError("Please enter your date of birth");
            Flag = true;
            return;
        }
        if(edtGrossIncome.getText().toString().isEmpty())
        {
            edtGrossIncome.setError("Please enter your Gross Income");
            Flag = true;
            return;
        }
        if(edtRRSP.getText().toString().isEmpty())
        {
            edtRRSP.setError("Please enter your date of birth");
            Flag = true;
            return;
        }

        if(!Flag)
        {
            CRACustomer craCustomer = new CRACustomer(edtSinNumber.getText().toString(),
                    edtFirstName.getText().toString(),
                    edtLastName.getText().toString(),
                    edtDOB.getText().toString(),
                    Double.parseDouble(edtGrossIncome.getText().toString()),
                    Double.parseDouble(edtRRSP.getText().toString()));
            Intent mIntent = new Intent(PersonInfoActivity.this, DataDisplayActivity.class);
            mIntent.putExtra("CRACustomer", craCustomer);
            startActivity(mIntent);
        }
    }
}



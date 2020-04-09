package com.example.c0775696_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.c0775696_w2020_mad3125_midterm.CRACustomer;

public class DataDisplayActivity extends AppCompatActivity {
    CRACustomer customer;
    private TextView lblSin,lblFullName,lblBirthDate,lblAge,lblGender;
    private TextView lblTaxFilingDate,lblGrossIncome,lblRRSPContributed,lblRRSPCarryFwd;
    private TextView lblFederalTax,lblProvincialTax,lblEI,lblCpp,lblTaxableIncome,lblTaxPayed;

    double cpp = 0, ei = 0;
    double rrspContribution = 0, rrspCarryFwd = 0;
    double taxableIncome, federalTax, provincialTax, totalTaxPaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        lblSin = findViewById(R.id.lblSinNumber);
        lblFullName = findViewById(R.id.lblFullName);
        lblBirthDate = findViewById(R.id.lblBirthDate);
        lblAge = findViewById(R.id.lblAge);
        lblGender = findViewById(R.id.lblGender);
        lblTaxFilingDate = findViewById(R.id.txtTaxFillDate);
        lblGrossIncome = findViewById(R.id.lblGrossIncome);
        lblRRSPContributed = findViewById(R.id.lblRrsContributed);
        lblRRSPCarryFwd = findViewById(R.id.lblCarryRrs);
        lblFederalTax = findViewById(R.id.lblFederalTax);
        lblProvincialTax = findViewById(R.id.lblProvincialTax);
        lblEI = findViewById(R.id.lblEi);
        lblCpp = findViewById(R.id.lblCpp);
        lblTaxableIncome = findViewById(R.id.lblTotalTaxIncome);
        lblTaxPayed = findViewById(R.id.lblTaxPayed);

        Intent mIntent = getIntent();
        CRACustomer customer = mIntent.getParcelableExtra("CRACustomer");

    }
}

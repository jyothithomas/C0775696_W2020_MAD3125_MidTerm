package com.example.c0775696_w2020_mad3125_midterm.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.c0775696_w2020_mad3125_midterm.Models.CRACustomer;
import com.example.c0775696_w2020_mad3125_midterm.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataDisplayActivity extends AppCompatActivity {
    CRACustomer customer;
    private TextView lblSin,lblFullName,lblBirthDate,lblAge,lblGender;
    private TextView lblTaxFilingDate,lblGrossIncome,lblRRSPContributed,lblRRSPCarryFwd;
    private TextView lblFederalTax,lblProvincialTax,lblEI,lblCpp,lblTaxableIncome,lblTaxPayed;

    int minAge = 18;
    double cpp = 0, ei = 0;
    double rrsp = 0, rrspContribution = 0, rrspCarryFwd = 0;
    double taxableIncome, federalTax, provincialTax, totalTaxPaid;

    String dt;
    final Calendar calendar = Calendar.getInstance();
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final   int month = calendar.get(Calendar.MONTH);
    final int year = calendar.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        lblSin = findViewById(R.id.lblSinNumber);
        lblFullName = findViewById(R.id.lblFullName);
        lblAge = findViewById(R.id.lblAge);
        lblGender = findViewById(R.id.lblGender);
        lblTaxFilingDate = findViewById(R.id.lblTaxFillDate);
        lblGrossIncome = findViewById(R.id.lblGrossIncome);
        lblRRSPContributed = findViewById(R.id.lblRrsContributed);
        lblRRSPCarryFwd = findViewById(R.id.lblCarryRrs);
        lblFederalTax = findViewById(R.id.lblFederalTax);
        lblProvincialTax = findViewById(R.id.lblProvincialTax);
        lblEI = findViewById(R.id.lblEi);
        lblCpp = findViewById(R.id.lblCpp);
        lblTaxableIncome = findViewById(R.id.lblTotalTaxIncome);
        lblTaxPayed = findViewById(R.id.lblTaxPayed);

        SimpleDateFormat dfDate_day= new SimpleDateFormat("E, dd/MM/yyyy");
        String dt="";
        Calendar c = Calendar.getInstance();
        dt = dfDate_day.format(c.getTime());
        lblTaxFilingDate.setText(dt);

       //lblTaxFilingDate.setText(new StringBuilder().append(day).append(" ").append("-").append(month + 1).append("-").append(year));

        Intent mIntent = getIntent();
        CRACustomer customer = mIntent.getParcelableExtra("CRACustomer");

        lblSin.setText( customer.getSinNumber());
        lblFullName.setText( customer.getFull_name());
        lblGender.setText(getIntent().getStringExtra("gender"));
        lblAge.setText(getIntent().getStringExtra("age"));
        if(lblAge.equals(null))
        {
            lblAge.setText("Not Eligible for Paying Tax");
        }
        lblGrossIncome.setText(String.valueOf(customer.getGrossIncome()));
        lblRRSPContributed.setText(String.valueOf(customer.getRrspContribution()));

        //lblTaxFilingDate.getText().toString() = date;
        // Cpp Calculation
        double grossIncome = customer.getGrossIncome();
        if(grossIncome > 57400.00){
            cpp = (57400.00 * 0.051); //5.10%
        } else {
            cpp = (grossIncome * 0.051);
        }
        lblCpp.setText(String.format("%.2f", cpp));

        // EI Calculation
        if(grossIncome > 53100){
            ei = (53100 * 0.0162); //1.62%
        }else{
            ei = (grossIncome * (1.62/100));
        }
        lblEI.setText(String.format("%.2f", ei));

        // RRSP Calculation
        rrsp = customer.getRrspContribution();
        double maxRRSP = (grossIncome * 0.18); //18%
        rrsp = customer.getRrspContribution();
        rrspCarryFwd = maxRRSP - rrsp ;

        if(rrspCarryFwd < 0)
        {
            lblRRSPCarryFwd.setTextColor(Color.RED);
            lblRRSPCarryFwd.setText(String.format("%.2f",rrspCarryFwd));
        }
        else
        {
            lblRRSPCarryFwd.setText(String.format("%.2f",rrspCarryFwd));
        }

        //Taxable income Calculation
        if(maxRRSP<rrsp)
        {
            taxableIncome = grossIncome - (cpp + ei + maxRRSP);
        }
        else if(maxRRSP>rrsp)
        {
            taxableIncome = grossIncome - (cpp + ei + rrsp);
        }

        lblTaxableIncome.setText(String.format("%.2f",taxableIncome));

        //Federal tax Calculation
        double calculateFederal = calculateFedralTax();
        lblFederalTax.setText( String.format("%.2f",calculateFederal));

        // Provincial Tax
        double calculateProvincial = calculateProvincialTax();
        lblProvincialTax.setText(String.format("%.2f",calculateProvincial));

        //Total Tax Payed
        totalTaxPaid = calculateFederal+ calculateProvincial;

        lblTaxPayed.setText( String.format("%.2f",totalTaxPaid));
    }
    public double calculateFedralTax(){
        //Function to calculate federal tax
        double temp = taxableIncome ;
        if((temp <= 12069.00) && (temp >= 0)){
            federalTax = 0;//0%
           // temp = taxableIncome - 12069.00;
        }
        else if((temp >= 12069.01) &&(temp<= 47630)){
            federalTax = (temp * 0.15);//15%
           // temp = temp - 35561;
        }
        else if((temp >= 47630.01)&&(temp<= 95259)){
            federalTax = (temp * 0.205); //20.50%
            //temp = temp - 47628.99;
        }
        else if((temp >= 95259.01)&&(temp<= 147667)){
            federalTax = (temp * 0.26); //26%
           // temp = temp - 52407.99;
        }
        else if ((temp >= 147667.01)&&(temp<= 210371)){
            federalTax = (temp * 0.29);//29%
            //temp = temp - 62703.99;
        }
        else if(temp >= 210371.01){
            federalTax = (temp * 0.33);//33%
            //temp = temp - federalTax;
        }
        return federalTax;
    }

    public  double calculateProvincialTax(){
        //Function to calculate provincial tax
        double temp = taxableIncome ;

        if(temp <= 10582.00){
            provincialTax = 0;
            //temp = taxableIncome - 10582.00;
        }
        else if((temp >= 10582.01)&&(temp <= 43906 )){
            provincialTax = (temp * 0.0505); //5.05%
            //temp = temp - 33323.99;
        }
        else if((temp >= 43906.01)&&(temp <= 87813 )){
            provincialTax = (temp * 0.0915); //9.15%
            //temp = temp - 43906.99;
        }
        else if((temp >= 87813.01)&&(temp <= 150000)){
            provincialTax = (temp * 0.1116); //11.16%
            //temp = temp - 62187.99;
        }
        else if ((temp >= 150000.01)&&(temp <= 220000)){
            provincialTax = (temp * 0.1216);//12.16%
            //temp = temp - 69999.99;
        }
        else if(temp >= 220000.01){
            provincialTax = (temp * 0.1316);//13.16%

        }
        return provincialTax;
    }
}

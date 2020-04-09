package com.example.c0775696_w2020_mad3125_midterm;

import java.util.Date;

public class CRACustomer {
    private String sinNumber;
    private String firstName;
    private String  lastName;
    private String fullName;
    private  String personGender;
    private Date dateOfBirth,filingTaxDate;
    private  double fedTax, provTax;
    private  double rrspCarryForward;
    private  double grossIncome;
    private double rrspContribution;
    private double totalEI;
    private double totalTaxableAmount;
    private double totalTaxPaid;

    public CRACustomer(String sinNumber,String firstName,String lastName,String personGender,double grossIncome, double rrspContribution)
    {
        this.sinNumber = sinNumber;
        this.firstName = firstName;
        this.personGender = personGender;
        this.grossIncome = grossIncome;
        this.rrspContribution = rrspContribution;

    }
}

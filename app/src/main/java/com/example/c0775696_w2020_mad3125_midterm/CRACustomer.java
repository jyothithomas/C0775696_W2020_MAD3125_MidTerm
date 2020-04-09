package com.example.c0775696_w2020_mad3125_midterm;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class CRACustomer implements Parcelable {
    private String sinNumber;
    private String firstName;
    private String lastName;
    private String fullName;
    private String personGender;
    private Date dateOfBirth, filingTaxDate;
    private double fedTax, provTax;
    private double rrspCarryForward;
    private double grossIncome;
    private double rrspContribution;
    private double totalEI;
    private double totalTaxableAmount;
    private double totalTaxPaid;



    public CRACustomer(String sinNumber, String firstName, String lastName, String personGender, double grossIncome, double rrspContribution) {
        this.sinNumber = sinNumber;
        this.firstName = firstName;
        this.personGender = personGender;
        this.grossIncome = grossIncome;
        this.rrspContribution = rrspContribution;

    }

    public String getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(String sinNumber) {
        this.sinNumber = sinNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFull_name() {
        return firstName+lastName;
    }

    public void setFull_name(String full_name) {
        this.fullName = full_name;
    }

    public String getPersonGender() {
        return personGender;
    }

    public void setPersonGender(String personGender) {
        this.personGender = personGender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getFilingTaxDate() {
        return filingTaxDate;
    }

    public void setFilingTaxDate(Date filingTaxDate) {
        this.filingTaxDate = filingTaxDate;
    }

    public double getFedTax() {
        return fedTax;
    }

    public void setFedTax(double fedTax) {
        this.fedTax = fedTax;
    }

    public double getProvTax() {
        return provTax;
    }

    public void setProvTax(double provTax) {
        this.provTax = provTax;
    }

    public double getRrspCarryForward() {
        return rrspCarryForward;
    }

    public void setRrspCarryForward(double rrspCarryForward) {
        this.rrspCarryForward = rrspCarryForward;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getRrspContribution() {
        return rrspContribution;
    }

    public void setRrspContribution(double rrspContribution) {
        this.rrspContribution = rrspContribution;
    }

    public double getTotalEI() {
        return totalEI;
    }

    public void setTotalEI(double totalEI) {
        this.totalEI = totalEI;
    }

    public double getTotalTaxableAmount() {
        return totalTaxableAmount;
    }

    public void setTotalTaxableAmount(double totalTaxableAmount) {
        this.totalTaxableAmount = totalTaxableAmount;
    }

    public double getTotalTaxPaid() {
        return totalTaxPaid;
    }

    public void setTotalTaxPaid(double totalTaxPaid) {
        this.totalTaxPaid = totalTaxPaid;
    }

    protected CRACustomer(Parcel parcel) {
        sinNumber = parcel.readString();
        firstName = parcel.readString();
        lastName = parcel.readString();
        personGender = parcel.readString();
        provTax = parcel.readDouble();
        fedTax = parcel.readDouble();
        rrspCarryForward = parcel.readDouble();
        grossIncome = parcel.readDouble();
        rrspContribution = parcel.readDouble();
        totalEI = parcel.readDouble();
        totalTaxableAmount = parcel.readDouble();
        totalTaxPaid = parcel.readDouble();

    }

    public static final Parcelable.Creator<CRACustomer> CREATOR = new Parcelable.Creator<CRACustomer>() {
        @Override
        public CRACustomer createFromParcel(Parcel parcel) {
            return new CRACustomer(parcel);
        }

        @Override
        public CRACustomer[] newArray(int size) {
            return new CRACustomer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
     public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sinNumber);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(personGender);
        dest.writeDouble(fedTax);
        dest.writeDouble(provTax);
        dest.writeDouble(rrspCarryForward);
        dest.writeDouble(grossIncome);
        dest.writeDouble(rrspContribution);
        dest.writeDouble(totalEI);
        dest.writeDouble(totalTaxableAmount);
        dest.writeDouble(totalTaxPaid);
    }

    public String amountFormatter() {
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String val = nf.format("$" + this);
        return val;
    }
}
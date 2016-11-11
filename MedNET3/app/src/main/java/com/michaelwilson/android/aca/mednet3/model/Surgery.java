package com.michaelwilson.android.aca.mednet3.model;


import java.io.Serializable;

public class Surgery implements Serializable{

    private String mProcedure;
    private String mLocation;
    private String mDate;

    public Surgery() {
        // Default constructor required for calls to DataSnapshot.getValue(Surgery.class)
    }

    public Surgery(String procedure, String location, String date) {
        this.mProcedure = procedure;
        this.mDate = date;
        this.mLocation = location;
    }

    public String getProcedure() {
        return mProcedure;
    }

    public void setProcedure(String procedure) {
        mProcedure = procedure;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public void convertToJSON() {

    }
}

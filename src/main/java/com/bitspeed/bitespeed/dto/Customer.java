package com.bitspeed.bitespeed.dto;

public class Customer {
    


    private String  email ;

    private String   phonenumber ;

    public Customer(){};

    public Customer(String email, String phonenumber) {
        super();
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    

    



}

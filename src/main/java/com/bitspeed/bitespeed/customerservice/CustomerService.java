package com.bitspeed.bitespeed.customerservice;

import com.bitspeed.bitespeed.exchanges.GetCustomerResponse;

public interface CustomerService {
    


    public  GetCustomerResponse getTheResponseAsPerEmail( String email);

    public  GetCustomerResponse   getTheResponseAsPerPhnumber(String phnumber);

    public  GetCustomerResponse  getTheResponseAsPerEmailAndPhnumber(String email,String phnumber);

    public boolean  updatelinkedid(int id ,  String linkedid);

    public void addnewlinkedcustomer(String email,String phnumber,String linkedid  );





}

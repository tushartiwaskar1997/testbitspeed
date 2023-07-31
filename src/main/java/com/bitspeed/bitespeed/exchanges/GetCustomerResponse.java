package com.bitspeed.bitespeed.exchanges;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import lombok.Data;



public class GetCustomerResponse{


    // "primaryContatctId": 11,
	// 		"emails": ["george@hillvalley.edu","biffsucks@hillvalley.edu"]
	// 		"phoneNumbers": ["919191","717171"]
	// 		"secondaryContactIds": [27]


    private int  primaryContatctId;

    private ArrayList<String> emails ;

    private ArrayList<String>  phoneNumbers;
    
    private ArrayList<String>  secondaryContactIds;

    
    public GetCustomerResponse(){};

    public GetCustomerResponse(int primaryContatctId, ArrayList<String> emails, ArrayList<String> phoneNumbers,
            ArrayList<String> secondaryContactIds) {
        this.primaryContatctId = primaryContatctId;
        this.emails = emails;
        this.phoneNumbers = phoneNumbers;
        this.secondaryContactIds = secondaryContactIds;
    }

    public int getPrimaryContatctId() {
        return primaryContatctId;
    }

    public void setPrimaryContatctId(int primaryContatctId) {
        this.primaryContatctId = primaryContatctId;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public ArrayList<String> getSecondaryContactIds() {
        return secondaryContactIds;
    }

    public void setSecondaryContactIds(ArrayList<String> secondaryContactIds) {
        this.secondaryContactIds = secondaryContactIds;
    }
   /*
    {
		"contact":{
			"primaryContatctId": 11,
			"emails": ["george@hillvalley.edu","biffsucks@hillvalley.edu"]
			"phoneNumbers": ["919191","717171"]
			"secondaryContactIds": [27]
		}
	}
   
   
   */ 
   
    
}

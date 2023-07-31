package com.bitspeed.bitespeed.repositoryServices;

import java.time.LocalDateTime;
import java.util.List;

import com.bitspeed.bitespeed.dto.Customer;
import com.bitspeed.bitespeed.models.CustomerEntity;

public interface CustomerRepositoryService {
    

List<CustomerEntity> findCustomerByEmailid(String emailid );

List<CustomerEntity> findCustomerByphonenumber(String phonenumber);

List<CustomerEntity> findCustomerByemailidAndPhoneNumber(String emailid,String phoneNumbers);

boolean  updatethelinkedid(int id,String linked_id);

void  createnewCustomer(String email,String phoneNumber , String linked_id ,String link_precedence);
void  createCustomer(String email,String phoneNumber  );


List<CustomerEntity> getallcustomerbyemailorphno(String email,String phoneNumbers);
String   getidfromEmailandphnumber(String email,String phoneNumbers);
void UpdateOldRecord(int id,String linked_id,String link_precedence);

}

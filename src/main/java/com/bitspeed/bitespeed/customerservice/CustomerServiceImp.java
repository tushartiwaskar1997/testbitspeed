package com.bitspeed.bitespeed.customerservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bitspeed.bitespeed.exchanges.GetCustomerResponse;
import com.bitspeed.bitespeed.models.CustomerEntity;
import com.bitspeed.bitespeed.repositoryServices.CustomerRepositoryService;

@Repository
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepositoryService customerRepositoryService;


    @Override
    public GetCustomerResponse getTheResponseAsPerEmail(String email) {
        // TODO Auto-generated method stub

        ArrayList<String> emList= new  ArrayList<>();
        ArrayList<String> phnlList= new  ArrayList<>();
        ArrayList<String> idlist= new  ArrayList<>();
 

        try { 
              
       for (CustomerEntity customerEntity :     customerRepositoryService.findCustomerByEmailid(email)) {

            emList.add(customerEntity.getEmail());
            phnlList.add(customerEntity.getPhoneNumber());
            idlist.add(customerEntity.getLinked_id());
       }

       

        } catch (Exception e) {
            // TODO: handle exception
             throw new UnsupportedOperationException("Unimplemented method 'getTheResponseAsPerEmail'");
        }
       return  new GetCustomerResponse(1, emList, phnlList, idlist);
    }








    @Override
    public GetCustomerResponse getTheResponseAsPerPhnumber(String phnumber) {
        // TODO Auto-generated method stub

        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        throw new UnsupportedOperationException("Unimplemented method 'getTheResponseAsPerPhnumber'");
    }








    @Override
    public GetCustomerResponse getTheResponseAsPerEmailAndPhnumber(String email, String phnumber) {
        // TODO Auto-generated method stub

        
        ArrayList<String> emList= new  ArrayList<>();
        ArrayList<String> phnlList= new  ArrayList<>();
        ArrayList<String> idlist= new  ArrayList<>();
        int  primaryid ;

        List<CustomerEntity> allcustomerdetails = new ArrayList<>();
        //allcustomerdetails=customerRepositoryService.findCustomerByemailidAndPhoneNumber(email,phnumber);

        if(customerRepositoryService.findCustomerByemailidAndPhoneNumber(email,phnumber).size()==0)
        {
            if(customerRepositoryService.findCustomerByEmailid(email).size()==0 && customerRepositoryService.findCustomerByphonenumber(phnumber).size()==0)
            {
                /// we will create new customer it primary tag
                customerRepositoryService.createCustomer(email, phnumber);
            }else if(customerRepositoryService.findCustomerByEmailid(email).size()!=0 )
            {   
                if(customerRepositoryService.getallcustomerbyemailorphno(email,phnumber).size()==2)
                {
                    List<CustomerEntity> list2 = new ArrayList<>();
                    list2=customerRepositoryService.getallcustomerbyemailorphno(email, phnumber);
                    customerRepositoryService.UpdateOldRecord(list2.get(1).getId(), list2.get(0).getId()+"", "secondary");
                    primaryid=list2.get(0).getId();
                }else
                {List<CustomerEntity> list = new ArrayList<>();
                list=customerRepositoryService.findCustomerByEmailid(email);
                //IF EMAIL IS PResent then take that id and make new entery with linked id  as id 
                addnewlinkedcustomer(email, phnumber, list.get(0).getId()+"");
                primaryid=list.get(0).getId();

                }

                
            }else
            {
                List<CustomerEntity> list1 = new ArrayList<>();
                list1 =customerRepositoryService.findCustomerByphonenumber(phnumber);
                addnewlinkedcustomer(email, phnumber, list1.get(0).getId()+"");
                primaryid=list1.get(0).getId();
            }

        }

            allcustomerdetails=customerRepositoryService.getallcustomerbyemailorphno(email, phnumber); //(email,phnumber);        
            for (CustomerEntity customerEntity :     allcustomerdetails) 
            {
            emList.add(customerEntity.getEmail());
            phnlList.add(customerEntity.getPhoneNumber());         
            idlist.add(customerEntity.getId()+"");
            }

            
        
          return new GetCustomerResponse(1, emList, phnlList, idlist);
 
    }








    @Override
    public boolean updatelinkedid(int id, String linkedid) {
        // TODO Auto-generated method stub


      
          return   customerRepositoryService.updatethelinkedid(id, linkedid);

        
    }








    @Override
    public void addnewlinkedcustomer(String email, String phnumber,String linkedid ) {
        // TODO Auto-generated method stub
        
        customerRepositoryService.createnewCustomer(email, phnumber,linkedid, "secondary");


    }

  }
       
       
    


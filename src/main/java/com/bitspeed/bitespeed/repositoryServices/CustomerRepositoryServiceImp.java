package com.bitspeed.bitespeed.repositoryServices;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitspeed.bitespeed.dto.Customer;
import com.bitspeed.bitespeed.exchanges.GetCustomerResponse;
import com.bitspeed.bitespeed.models.CustomerEntity;
import com.bitspeed.bitespeed.repositories.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CustomerRepositoryServiceImp  implements CustomerRepositoryService    {

    @PersistenceContext
    private EntityManager entityManager;  //this is used for the insert query specially

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> findCustomerByEmailid(String emailid) {
        
        List<CustomerEntity> findCustomerResponses = new ArrayList<>();       
       try {
            findCustomerResponses=  customerRepository.findCustomerByemail(emailid);
       } catch (Exception e) {
        throw new UnsupportedOperationException("Unimplemented method 'findCustomerByEmailid'");
       }
        return findCustomerResponses;       
    }

    @Override
    public List<CustomerEntity> findCustomerByphonenumber(String phonenumber) {
        return customerRepository.findCustomerByphoneNumber(phonenumber);
    }

    @Override
    public List<CustomerEntity> findCustomerByemailidAndPhoneNumber(String emailid, String phoneNumbers) {

        List<CustomerEntity> findCustomerResponses = new ArrayList<>();
        findCustomerResponses=  customerRepository.findCustomerByemailAndphonenumber(emailid,phoneNumbers);

            //   if(findCustomerResponses.size()==0)
            //   {
            //     createnewCustomer(emailid,phoneNumbers,"2","secondary");
            //   }
              
            //   System.out.println(findCustomerResponses.size()+"size of list");

              //findCustomerResponses=  customerRepository.findCustomerByemailAndphonenumber(emailid,phoneNumbers);

              
        
        return findCustomerResponses;
    }

    @Override
    public boolean updatethelinkedid(int id, String linked_id) {
        
       
             customerRepository.UpdatelinkedidByid( linked_id,id);

            
      
        return true;
      
    }

    @Override
    @Transactional
    public void createnewCustomer(String email, String phoneNumber, String linked_id, String link_precedence ) {
        // TODO Auto-generated method stub
        
         LocalDateTime created_at = LocalDateTime.now();
        LocalDateTime updated_at = LocalDateTime.now();
            entityManager.createNativeQuery("INSERT INTO `customer`(  `email`, `phone_number`, `linked_id`, `link_precedence`, `created_at`, `updated_at`)VALUES(?,?,?,?,?,?)")
       .setParameter(1,email)
       .setParameter(2, phoneNumber)
       .setParameter(3, linked_id)
       .setParameter(4, link_precedence)
       .setParameter(5, created_at)
       .setParameter(6, updated_at).executeUpdate();
       
    //    // customerRepository.insertnewcusotmer(email, phoneNumber, linked_id, link_precedence, created_at, updated_at);
    //    entityManager.createNamedQuery("INSERT INTO `customer`(  'id',`email`, `phone_number`, `linked_id`, `link_precedence`, `created_at`, `updated_at`, `deleted_at`)VALUES(NULL,?,?,?,?,?,?,NULL)")
    //    .setParameter(1,email)
    //    .setParameter(2, phoneNumber)
    //    .setParameter(3, linked_id)
    //    .setParameter(4, link_precedence)
    //    .setParameter(5, created_at)
    //    .setParameter(6, updated_at).executeUpdate();
       
            
      
        
    }

    @Override
    public List<CustomerEntity> getallcustomerbyemailorphno(String email, String phoneNumbers) {
        // TODO Auto-generated method stub
            List<CustomerEntity> list= new ArrayList<>();
       list =  customerRepository.findcustomerbyemailorphnumber(email,phoneNumbers);
       return list;
    }

    @Override
    public String getidfromEmailandphnumber(String email, String phoneNumbers) {
       return    customerRepository.gettheid(email,phoneNumbers)+"";
    }

    @Override
    @Transactional
    public void createCustomer(String email, String phoneNumber) {
       LocalDateTime created_at = LocalDateTime.now();
        LocalDateTime updated_at = LocalDateTime.now();
            entityManager.createNativeQuery("INSERT INTO `customer`(  `email`, `phone_number`,  `link_precedence`, `created_at`, `updated_at`)VALUES(?,?,'primary',?,?)")
       .setParameter(1,email)
       .setParameter(2, phoneNumber)    
       .setParameter(3, created_at)
       .setParameter(4, updated_at).executeUpdate();
    }

    @Override
    public void UpdateOldRecord(int id, String linked_id, String link_precedence) {
        customerRepository.updatelinkedidandpref(id, linked_id, link_precedence);



    }
    
}

//"INSERT INTO `customer` (`id`, `email`, `phone_number`, `linked_id`, `link_precedence`, `created_at`, `updated_at`, `deleted_at`) VALUES (NULL,?1 , ?2, ?3, ?4, 5?, 6?, NULL)
    // entityManager.createNativeQuery("INSERT INTO person (id, first_name, last_name) VALUES (?,?,?)")
    //   .setParameter(1, person.getId())
    //   .setParameter(2, person.getFirstName())
    //   .setParameter(3, person.getLastName())
    //   .executeUpdate();

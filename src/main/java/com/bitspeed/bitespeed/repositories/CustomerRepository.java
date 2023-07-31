package com.bitspeed.bitespeed.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitspeed.bitespeed.dto.Customer;
import com.bitspeed.bitespeed.models.CustomerEntity;
@EnableJpaRepositories
public interface CustomerRepository  extends  JpaRepository<CustomerEntity,String> {

       // @Query("{'emailid': {$regex: '.*?0.*', $options: 'i'}}")
        //@Query(value = "SELECT * FROM customer  ORDER BY email")
       // @Query("SELECT b.id,b.email,b.phonenumber FROM customer b WHERE b.email = ?1 ")
       // @Query("select c1_0.id,c1_0.created_at,c1_0.deleted_at,c1_0.email,c1_0.link_precedence,c1_0.linked_id,c1_0.phone_number,c1_0.updated_at from customer c1_0 where c1_0.email=tushar")
        List<CustomerEntity>  findCustomerByemail(String email);
      
       // @Query("{'phonenumber': {$regex: '.*?0.*', $options: 'i'}}")
        List<CustomerEntity>  findCustomerByphoneNumber(String phoneNumber);
       // SELECT * FROM `customer` WHERE `email` = 'tushar' AND `phone_number` = '7276367780'

        @Query( value="SELECT * FROM customer  WHERE email = ?1 AND phone_number=?2 ",nativeQuery=true)
        List<CustomerEntity>  findCustomerByemailAndphonenumber(String email,String phoneNumber);
       // UPDATE `customer` SET `linked_id` = '0' WHERE `customer`.`id` = 2;
       //@Query("UPDATE Laptop SET price = :price WHERE name = :name")
        @Transactional
        @Modifying
        @Query(value = "UPDATE customer SET linked_id =?1 WHERE customer.id=?2",nativeQuery = true)
        void  UpdatelinkedidByid(String linked_id ,int id);

        @Transactional
        @Modifying
        @Query(value = "UPDATE customer SET linked_id =?2,link_precedence=?3 WHERE customer.id=?1",nativeQuery = true)
        void  updatelinkedidandpref(int id ,String linked_id ,String  link_precedence);
        
        
        //INSERT INTO `customer` 
        //(`id`, `email`, `phone_number`, `linked_id`, `link_precedence`, `created_at`, `updated_at`, `deleted_at`) 
       // VALUES (NULL, 'prajwal', '7376367780', '1', 'secondary', '2023-07-19 00:56:26.000000', '2023-07-20 00:56:26.000000', NULL);
        @Transactional
        @Query(value = "INSERT INTO `customer` (`id`, `email`, `phone_number`, `linked_id`, `link_precedence`, `created_at`, `updated_at`, `deleted_at`) VALUES (NULL,?1 , ?2, ?3, ?4, 5?, 6?, NULL)",nativeQuery = true)
        void  insertnewcusotmer(String email,String phoneNumber , String linked_id ,String link_precedence,
        LocalDateTime created_at ,LocalDateTime updated_at );

        @Query(value = "select id from customer where email=?1 and phone_number =?2 and link_precedence='primary' ",nativeQuery = true)
        String gettheid(String email,String phoneNumber);

        @Query( value="SELECT * FROM customer  WHERE email = ?1 OR phone_number=?2 ",nativeQuery=true)
        List<CustomerEntity>  findcustomerbyemailorphnumber(String email,String phoneNumber);




}
 
package com.bitspeed.bitespeed.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitspeed.bitespeed.customerservice.CustomerService;
import com.bitspeed.bitespeed.dto.Customer;
import com.bitspeed.bitespeed.exchanges.GetCustomerResponse;
import com.bitspeed.bitespeed.repositoryServices.CustomerRepositoryService;

@RestController
public class CusomerController {

    
//curl -X POST http://localhost:8080/identify -H 'Content-Type: application/json'   -d '{"email":"3","phonenumber":"Mark"}'
//curl POST http://localhost:8080/identify?ans={"email":"3","phonenumber":"Mark"}
// curl  http://localhost:8080/identify?'{"email":"3","phonenumber":"Mark"}'
/* 
curl -X POST \ http://localhost:8080/identify/ans \  -H 'cache-control: no-cache' \  -H 'content-type: application/json' \  -d '{
  "email":"test9@test.com",
  "phonenumber":"123"
}'
*/
/* 
curl    http://localhost:8080/identify/'{
  "email":"test9@test.com",
  "phonenumber":"123"}'
*/

// @PostMapping(path = "users", 
//         consumes = MediaType.APPLICATION_JSON_VALUE, 
//         produces = MediaType.APPLICATION_JSON_VALUE)

//@PostMapping("/identify",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
// @PostMapping(path="/post/ans" ,
//         consumes = MediaType.APPLICATION_JSON_VALUE,
//         produces = {"text/plain", "application/*"})
// curl -v -H "Content-Type: application/json" -X POST \
//      -d '{"email":"your name","phonenumber":"111-111"}' http://localhost:8080/post
/**
 * @param ans
 * @return
 */

@Autowired
private CustomerService customerService;

@PostMapping("/post")
public ResponseEntity<?> getrespose(@RequestBody Customer ans )
{
    String emailofcustomer=  ans.getEmail();
    String phnum0fcustomer=  ans.getPhonenumber();
    GetCustomerResponse getCustomerResponse;

    if(emailofcustomer!="" && phnum0fcustomer!="")
    {
      getCustomerResponse  =customerService.getTheResponseAsPerEmailAndPhnumber(ans.getEmail(),ans.getPhonenumber());
    }else if( emailofcustomer!="" && phnum0fcustomer=="")
    {
      getCustomerResponse  =customerService.getTheResponseAsPerEmail(ans.getEmail());
    }else
    {
      getCustomerResponse  =customerService.getTheResponseAsPerEmail(ans.getPhonenumber());
    }

   
    System.out.println("FORM THE POST MAPPIING ");
   
    return    ResponseEntity.ok().body(getCustomerResponse); 
}

@PostMapping("/upd")
public ResponseEntity<?> setfield(@RequestBody Customer ans )
{

    //GetCustomerResponse  getCustomerResponse ;//= new GetCustomerResponse();

   

   System.out.println( customerService.updatelinkedid(2, "1"));

    


    return    ResponseEntity.ok().body(true); 
}

@PostMapping("/insert")
public ResponseEntity<?> insertnew(@RequestBody Customer ans )
{

    //GetCustomerResponse  getCustomerResponse ;//= new GetCustomerResponse();

   

    customerService.addnewlinkedcustomer(ans.getEmail(), ans.getPhonenumber(), "0");


    return    ResponseEntity.ok().body(true); 
}



@GetMapping("/find")
public String getthevalues()
{
    
    System.out.println("FORM THE POST MAPPIING ");
    return "";
}
}


//

//SELECT * from customer where  email='george@hillvalley.edu' and phone_number='717171'


// SELECT * from customer where  email='george@hillvalley.edu' OR phone_number='717171'
// select * from customer  where email='george@hillvalley.edu' set PRIMARY
// select * from customer where phnu=''7171717 set as secondary and linkedId  = fristone 
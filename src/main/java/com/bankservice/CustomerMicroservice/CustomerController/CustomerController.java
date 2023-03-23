package com.bankservice.CustomerMicroservice.CustomerController;

import com.bankservice.CustomerMicroservice.CustomerRepository.CustomerRepository;
import com.bankservice.CustomerMicroservice.CustomerService.CustomerService;
import com.bankservice.CustomerMicroservice.model.CustomerLoginModel;
import com.bankservice.CustomerMicroservice.model.CustomerModel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:4200")
public class CustomerController {

    @Autowired
    CustomerService service;
    
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/register")
    public String registration(@RequestBody CustomerModel model){

       return service.registration(model);

    }
    
   @PostMapping("/login")
   public String login(@RequestBody CustomerLoginModel model) {
	   return service.login(model);
   }
}

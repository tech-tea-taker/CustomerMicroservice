package com.bankservice.CustomerMicroservice.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankservice.CustomerMicroservice.CustomerService.AccountDetailsService;
import com.bankservice.CustomerMicroservice.model.CustomerAccountDetailsModel;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/account/details")
public class AccountDetailsController {
	
	@Autowired
	AccountDetailsService service;
	
	@GetMapping("/create/{id}")
	public String createAccount( @PathVariable("id") String id) {
		return service.createAccount(id);
	}

}

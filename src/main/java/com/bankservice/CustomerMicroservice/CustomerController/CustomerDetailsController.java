package com.bankservice.CustomerMicroservice.CustomerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankservice.CustomerMicroservice.CustomerService.CustomerDetailsService;
import com.bankservice.CustomerMicroservice.model.CustomerModel;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/customer/details")
public class CustomerDetailsController {
	
	@Autowired
	CustomerDetailsService customerDetailsService;
	
	@GetMapping("/all")
	public List<CustomerModel> getAll() {
		return customerDetailsService.getall();
	}

	@GetMapping("/approved/{id}")
	public String approved(@PathVariable("id") String id) {
		return customerDetailsService.approved(id);
	}
	
	
}

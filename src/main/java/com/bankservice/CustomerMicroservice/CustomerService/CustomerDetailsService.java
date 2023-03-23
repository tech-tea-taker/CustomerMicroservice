package com.bankservice.CustomerMicroservice.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankservice.CustomerMicroservice.CustomerRepository.CustomerRepository;
import com.bankservice.CustomerMicroservice.model.CustomerModel;

@Service
public class CustomerDetailsService {
	
	@Autowired
	CustomerRepository repo;
	
	public List<CustomerModel> getall() {
		return  repo.findAll();
	}
	
	public String approved(String id) {
		repo.updatetoapproved(id);
		return "approved";
	}

}

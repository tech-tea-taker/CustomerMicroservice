package com.bankservice.CustomerMicroservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.bankservice.CustomerMicroservice.CustomerRepository.CustomerLoginRepository;
import com.bankservice.CustomerMicroservice.CustomerRepository.CustomerRepository;
import com.bankservice.CustomerMicroservice.model.CustomerLoginModel;
import com.bankservice.CustomerMicroservice.model.CustomerModel;

@Component
public class CustomerServiceDetails implements UserDetailsService{
	
	@Autowired
	CustomerLoginRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		CustomerLoginModel model=repo.findById(username).get();
		
		return new CustomerDetails(model);
	}

}

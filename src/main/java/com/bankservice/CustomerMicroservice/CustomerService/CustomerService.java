package com.bankservice.CustomerMicroservice.CustomerService;

import java.time.LocalDate;

import com.bankservice.CustomerMicroservice.CustomerRepository.CustomerRepository;
import com.bankservice.CustomerMicroservice.UserIdgenerator.userIdGenerator;
import com.bankservice.CustomerMicroservice.jwt.CustomerUtils;
import com.bankservice.CustomerMicroservice.model.CustomerLoginModel;
import com.bankservice.CustomerMicroservice.model.CustomerModel;
import com.bankservice.CustomerMicroservice.security.CustomerDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repo;

	@Autowired
	userIdGenerator generator;

	@Autowired
	AuthenticationManager authmanager;

	@Autowired
	CustomerUtils util;
	

	

	public String registration(CustomerModel model) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		LocalDate date = LocalDate.now();
		String encrypted_password=encoder.encode(model.getPassword());
		model.setPassword(encrypted_password);
		String id=UUID.randomUUID().toString();
		model.setId(id);
		model.setSubmit_date(date.toString());
		model.setApprove(0);
		model.setEmail_sent(0);
		repo.save(model);


		
		return "added";
	}

	public String login(CustomerLoginModel model) {

		try {
			org.springframework.security.core.Authentication auth = authmanager
					.authenticate(new UsernamePasswordAuthenticationToken(model.getUserID(), model.getPassword()));

			if (auth.isAuthenticated()) {
				CustomerDetails details = new CustomerDetails(model);
				String token = util.generatetoken(details);
				return token;
			}
			return "user not authenticated";

		} catch (Exception e) {
			if (repo.findById(model.getUserID()).isPresent()) {
				CustomerModel mdle = repo.findById(model.getUserID()).get();

				if (!mdle.getPassword().equals(model.getPassword())) {
					return "email or password does not match";
				}
			}
			return "there is an error";

		}
	}
}

package com.bankservice.CustomerMicroservice.CustomerService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankservice.CustomerMicroservice.CustomerRepository.AccountDetailsRepo;
import com.bankservice.CustomerMicroservice.CustomerRepository.CustomerRepository;
import com.bankservice.CustomerMicroservice.CustomerRepository.TransactionRepository;
import com.bankservice.CustomerMicroservice.UserIdgenerator.userIdGenerator;
import com.bankservice.CustomerMicroservice.model.CustomerAccountDetailsModel;
import com.bankservice.CustomerMicroservice.model.CustomerModel;
import com.bankservice.CustomerMicroservice.model.CustomerTransactionModel;

@Service
public class AccountDetailsService {
	

	
	@Autowired
     AccountDetailsRepo repo;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	userIdGenerator generator;
	
	
	public String createAccount(String id ) {
		if(customerRepository.findById(id).isPresent()) {
			
			CustomerModel customerModel=customerRepository.findById(id).get();
			
			if(customerModel.getApprove()==0) {
				return "waiting";
			}
			else {
				CustomerAccountDetailsModel model=new CustomerAccountDetailsModel();
				LocalDate date = LocalDate.now();

				model.setId(customerModel.getId());
				model.setName(customerModel.getName());
				model.setUser_id(generator.idgenerator());
				model.setAccount_number(generator.accountNumber());
				model.setTotalAmount(1000);
				model.setIfsc(generator.ifscCode());
				model.setBranch_code(generator.branchCode());
				model.setPhone_no(customerModel.getPhone_no());
				model.setEmail(customerModel.getEmail());
				model.setPan(customerModel.getPancard());
				model.setAddhar(customerModel.getAddharcard());
				model.setDate(date.toString());
				
				repo.save(model);
				
				return "Account created";

			}
			
			
		}else {
	
		return "Account not created";
		}
	}
}

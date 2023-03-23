package com.bankservice.CustomerMicroservice.CustomerRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bankservice.CustomerMicroservice.model.CustomerAccountDetailsModel;
import com.bankservice.CustomerMicroservice.model.CustomerTransactionModel;


public interface AccountDetailsRepo extends JpaRepository<CustomerAccountDetailsModel, String>{

	@Query(value = "SELECT * FROM accountdetails where user_id=?",nativeQuery = true)
	public CustomerAccountDetailsModel getAccountDetailsModel(String userId);
	
	@Query(value = "SELECT * FROM accountdetails where account_number=?",nativeQuery = true)
	public CustomerAccountDetailsModel getReceiverAccountDetailsModel(String userId);


	
}

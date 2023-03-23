package com.bankservice.CustomerMicroservice.CustomerRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankservice.CustomerMicroservice.model.CustomerLoginModel;

public interface CustomerLoginRepository extends JpaRepository<CustomerLoginModel, String>{

}

package com.bankservice.CustomerMicroservice.CustomerRepository;

import com.bankservice.CustomerMicroservice.model.CustomerModel;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<CustomerModel,String> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE login t SET t.approve=1 where t.id=?",nativeQuery = true)
	void updatetoapproved(String id);
}

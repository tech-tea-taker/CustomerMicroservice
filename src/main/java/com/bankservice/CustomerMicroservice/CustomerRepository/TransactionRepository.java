package com.bankservice.CustomerMicroservice.CustomerRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bankservice.CustomerMicroservice.model.CustomerTransactionModel;

public interface TransactionRepository extends JpaRepository<CustomerTransactionModel, String>{

	@Query(value="select * from tranaction where sender_account_no=?1 and  money_reciving_date >= ?2 AND money_reciving_date <=?3",nativeQuery = true)
	public List<CustomerTransactionModel> findByDebitAccountNo(String acNo ,String start_date,String end_date); 
	
	@Query(value="select * from tranaction where reciver_account_no=?1 and  money_reciving_date >= ?2 AND money_reciving_date <=?3",nativeQuery = true)
	public List<CustomerTransactionModel> findByCreditAccountNo(String acNo ,String start_date,String end_date); 
	
}

package com.bankservice.CustomerMicroservice.CustomerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankservice.CustomerMicroservice.CustomerService.TranactionService;
import com.bankservice.CustomerMicroservice.model.CustomerAccountDetailsModel;
import com.bankservice.CustomerMicroservice.model.CustomerTransactionModel;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/transaction")
public class TranactionController {

	@Autowired
	TranactionService service;
	
	@PostMapping("/sent/{id}")
	public String moneySent(@RequestBody CustomerTransactionModel model,@PathVariable("id") String id) {
		return service.moneySent(model,id);
	}
	
	@GetMapping("/account/details/{id}")
	public CustomerAccountDetailsModel getCustomerAccountDetails(@PathVariable("id") String userId) {
		return service.getAccountDetails(userId);
	}
	
	@GetMapping("/account/debit/{acNo}/{startDate}/{endDate}")
	public List<CustomerTransactionModel> debit(@PathVariable("acNo")	String acNo, @PathVariable("startDate") String startDate ,@PathVariable("endDate") String endDate) {
		return service.debitTransaction(acNo,startDate,endDate);
	}
	
	@GetMapping("/account/credit/{acNo}/{startDate}/{endDate}")
	public List<CustomerTransactionModel> credit(@PathVariable("acNo")	String acNo,@PathVariable("startDate") String startDate ,@PathVariable("endDate") String endDate) {
		return service.creditTransaction(acNo,startDate,endDate);
	}

}

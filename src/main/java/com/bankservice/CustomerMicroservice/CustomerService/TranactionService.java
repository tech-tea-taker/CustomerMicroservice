package com.bankservice.CustomerMicroservice.CustomerService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankservice.CustomerMicroservice.CustomerRepository.AccountDetailsRepo;
import com.bankservice.CustomerMicroservice.CustomerRepository.TransactionRepository;
import com.bankservice.CustomerMicroservice.UserIdgenerator.userIdGenerator;
import com.bankservice.CustomerMicroservice.model.CustomerAccountDetailsModel;
import com.bankservice.CustomerMicroservice.model.CustomerTransactionModel;

@Service
public class TranactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountDetailsRepo accountDetailsRepository;
	
	@Autowired
	userIdGenerator generator;
	

	

	public String moneySent( CustomerTransactionModel model,String id) {
		Date date=new Date();
		 SimpleDateFormat ft = 
			      new SimpleDateFormat ("yyyy-MM-dd  hh:mm");
		
		model.setTranactionId(generator.tranactionId());
		model.setMoneyRecivingDate(ft.format(date));
		
		
		CustomerAccountDetailsModel mdl=accountDetailsRepository.getAccountDetailsModel(id);
		long amount=mdl.getTotalAmount()-model.getDebitedAmount();
		mdl.setTotalAmount(amount);
		
		
		CustomerAccountDetailsModel receivermdl=accountDetailsRepository.getReceiverAccountDetailsModel(model.getReciverAccountNo());
		long receiveramount=receivermdl.getTotalAmount()+model.getDebitedAmount();
		receivermdl.setTotalAmount(receiveramount);
		
		
		
		
		transactionRepository.save(model);
		accountDetailsRepository.save(mdl);
		accountDetailsRepository.save(receivermdl);
		
		
		return "Money Sent";
	}
	
	
	
	public CustomerAccountDetailsModel getAccountDetails(String id) {
	  return	accountDetailsRepository.getAccountDetailsModel(id);
	}
	
	public List<CustomerTransactionModel> debitTransaction(String acNo, String startDate , String endDate) {
		return transactionRepository.findByDebitAccountNo(acNo,startDate,endDate);
	}
	
	public List<CustomerTransactionModel> creditTransaction(String acNo,String startDate , String endDate) {
		return transactionRepository.findByCreditAccountNo(acNo,startDate,endDate);
	}

}

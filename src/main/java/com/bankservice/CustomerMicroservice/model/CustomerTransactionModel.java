package com.bankservice.CustomerMicroservice.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tranaction")
public class CustomerTransactionModel {

	
	@Id
	@Column(name="tranaction_id")
	private String tranactionId;
	@Column(name="sender_account_no")
	private String senderAccountNo;
	@Column(name="sender_total_balance")
	private long  sendertotalBalance;
	@Column(name="debited_amount")
	private long debitedAmount;
	@Column(name="reciver_account_no")
	private String reciverAccountNo;
	@Column(name="reciver_ifsc")
	private String reciverIfsc;
	@Column(name="receiver_name")
	private String receiverName; 
	@Column(name="money_reciving_date")
	private String moneyRecivingDate;
	
	
	public String getTranactionId() {
		return tranactionId;
	}
	public void setTranactionId(String tranactionId) {
		this.tranactionId = tranactionId;
	}
	public String getSenderAccountNo() {
		return senderAccountNo;
	}
	public void setSenderAccountNo(String senderAccountNo) {
		this.senderAccountNo = senderAccountNo;
	}
	public long getSendertotalBalance() {
		return sendertotalBalance;
	}
	public void setSendertotalBalance(long sendertotalBalance) {
		this.sendertotalBalance = sendertotalBalance;
	}
	public long getDebitedAmount() {
		return debitedAmount;
	}
	public void setDebitedAmount(long debitedAmount) {
		this.debitedAmount = debitedAmount;
	}
	public String getReciverAccountNo() {
		return reciverAccountNo;
	}
	public void setReciverAccountNo(String reciverAccountNo) {
		this.reciverAccountNo = reciverAccountNo;
	}
	public String getReciverIfsc() {
		return reciverIfsc;
	}
	public void setReciverIfsc(String reciverIfsc) {
		this.reciverIfsc = reciverIfsc;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getMoneyRecivingDate() {
		return moneyRecivingDate;
	}

	public void setMoneyRecivingDate(String moneyRecivingDate) {
		this.moneyRecivingDate = moneyRecivingDate;
	}



	public CustomerTransactionModel(String tranactionId, String senderAccountNo, long sendertotalBalance,
			long debitedAmount, String reciverAccountNo, String reciverIfsc, String receiverName,
			String moneyRecivingDate) {
		super();
		this.tranactionId = tranactionId;
		this.senderAccountNo = senderAccountNo;
		this.sendertotalBalance = sendertotalBalance;
		this.debitedAmount = debitedAmount;
		this.reciverAccountNo = reciverAccountNo;
		this.reciverIfsc = reciverIfsc;
		this.receiverName = receiverName;
		this.moneyRecivingDate = moneyRecivingDate;
	}
	
	public CustomerTransactionModel() {
		super();
	}
	
	
	
	
}

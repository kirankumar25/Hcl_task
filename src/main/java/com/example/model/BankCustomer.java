package com.example.model;

public class BankCustomer {

	
	public String TransactionId;
	public String  credit;
	public String debit;
	public String balance;
	
	public BankCustomer() {
		
	}
	public BankCustomer(String TransactionId,String credit,String debit,String balance){
		this.TransactionId=TransactionId;
		this.credit=credit;
		this.debit=debit;
		this.balance=balance;
	}
	public String getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
}

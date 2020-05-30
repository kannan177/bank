package com.zoho.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")

public class TransferHistory {
	private String Sender_name;
    private String  receiver_name;
    private long  sender_accountno;
    private long receiver_accountno;
    private String transactiondate;
    private double amount;
    
	public String getSender_name()
	{
		
		return Sender_name;
		
	}
	public void setSender_name(String sender_name) 
	{
		
		Sender_name = sender_name;
		
	}
	public String getReceiver_name()
	{
		
		return receiver_name;
		
	}
	public void setReceiver_name(String receiver_name)
	{
		
		this.receiver_name = receiver_name;
		
	}
	public long getSender_accountno() 
	{
		
		return sender_accountno;
		
	}
	public void setSender_accountno(long sender_accountno)
	{
		
		this.sender_accountno = sender_accountno;
		
	}
	public long getReceiver_accountno()
	{
		
		return receiver_accountno;
		
	}
	public void setReceiver_accountno(long receiver_accountno)
	{
		
		this.receiver_accountno = receiver_accountno;
		
	}
	public String getTransactiondate()
	{
		
		return transactiondate;
		
	}
	public void setTransactiondate(String transactiondate)
	{
		
		this.transactiondate = transactiondate;
		
	}
	public double getAmount()
	{
		
		return amount;
		
	}
	public void setAmount(double amount) 
	{
		
		this.amount = amount;
		
	}
    
}

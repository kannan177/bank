package com.zoho.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class person {
	
	private  String name ;
    private  long AccountNumber;
    private  double Balance;
    private  String Password;
    private  int upi;
    private  long phonenumber;

   public  int getUpi() 
   {
       return upi;
   }

   public  void setUpi(int upi) 
   {
           this.upi = upi;
   }

   public  long getPhonenumber() 
   {
       return phonenumber;
   }

   public  void setPhonenumber(long phonenumber) 
   {
	   this.phonenumber = phonenumber;
   }
 public void setPassword(String Password)
 {
	 this.Password=Password;
 }
 public void setName(String name)
       {
	 this.name = name;
	}
 public void setAccountNumber(long AccountNumber) 
       {
	 this.AccountNumber = AccountNumber;
	}
 public void setBalance(double Balance) 
       {
	 this.Balance= Balance;
	}

   public String getName() {
       return name;
   }

   public long getAccountNumber() {
       return AccountNumber;
   }

   public double getBalance() {
       return Balance;
   }

   public String getPassword() {
       return Password;
   }
   

}

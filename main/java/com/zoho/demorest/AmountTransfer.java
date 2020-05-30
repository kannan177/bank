package com.zoho.demorest;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("transfer")
public class AmountTransfer {
	
    @Path("amounttransfer")
    @POST
    @Produces({MediaType.TEXT_PLAIN})
	public String AmountTransfer1(@FormParam("t1") Long senderNo,
			 @FormParam("t2") Long receiverNo,
			 @FormParam("upi") int upi,
			 @FormParam("receiver") String Receiver_name,
			 @FormParam("t3") long amount) throws SQLException
    	{

			DBmanager dbManager = DBmanager.getInstance();
			
			person pr=dbManager.getpersonInstnce();
			
			if((dbManager.checkAvailable(senderNo))&&(dbManager.checkAvailable(receiverNo))&&(upi==pr.getUpi()))
				
			{   
				
			if( dbManager . Withdraw(pr.getAccountNumber(),amount))
				
			{
				
					dbManager . AmountTransfer (receiverNo,amount);
					
					pr.setBalance ( (pr.getBalance() - amount) );            
					
					DateTimeFormatter dtf = DateTimeFormatter . ofPattern ("yyyy/MM/dd");
					
					LocalDateTime now = LocalDateTime . now();
										
					dbManager . AddTransferDetail ( (pr.getName()), Receiver_name, senderNo, receiverNo,( dtf.format (now) ),amount);
					return "Transaction sucessfully complete";
			}
			
			else
			{
				return "please maintain the minimum balankce ";
			}
			
			}
			else
				 return "Please enter the corrct details ";
		
    	}
   
			
}

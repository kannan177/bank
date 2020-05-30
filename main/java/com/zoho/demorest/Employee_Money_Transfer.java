package com.zoho.demorest;

import java.time.format.DateTimeFormatter;
import java.sql.SQLException;
import java.time.LocalDateTime;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("Employee_Money_Transfer")
public class Employee_Money_Transfer {
	 DBmanager dbManager = DBmanager.getInstance();

	@Path("transfer")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String transfer(@FormParam("t1") long senderNo,
			 @FormParam("t2") long receiverNo,
			 @FormParam("upi") int upi,
			 @FormParam("receiver") String Receiver_name,
			 @FormParam("sender") String Sender_name,
			 @FormParam("t3") long amount)
	{
		
		 
		 if((dbManager.checkAvailable(senderNo))&&(dbManager.checkAvailable(receiverNo)))
         {                  
                                   
                if( dbManager . Withdraw(senderNo,amount) )
                         {
                                dbManager . AmountTransfer (receiverNo,amount);
                         
                 
                  DateTimeFormatter dtf = DateTimeFormatter . ofPattern ("yyyy/MM/dd");
                  
                  LocalDateTime now = LocalDateTime . now();
                  
                 try {
					dbManager . AddTransferDetail (Sender_name , Receiver_name, senderNo, receiverNo,( dtf.format (now) ),amount);
				} catch (SQLException e) {
					e.printStackTrace();
				}
                 
                 return "Transfered Successfully";
                         }
                else
                    return "Please maintain the minimum balance Transactionclosed";
         }
             else
             {
            	 return "Please enter the correct value";
             }
		
	}
	
	
	 	@Path("withdraw")
	    @POST
	    @Produces(MediaType.TEXT_PLAIN)
	    public String AmountWithDraw(@FormParam("Acc_No") Long Acc_No,
	    		@FormParam ("Amount") Long Amount )
	    {
	    	
		 if( ( dbManager.checkAvailable(Acc_No) ) )
         {                  
                                   
                if( dbManager . Withdraw ( Acc_No , Amount ) )
                         {
                                                        
                 return "Amount Dectected Successfully";
                 
                         }
                
                else
                	
                    return "Please maintain the minimum balance Transactionclosed";
                
         }
             else
             {
            	 return "Please enter the correct value";
             }
	    }
}

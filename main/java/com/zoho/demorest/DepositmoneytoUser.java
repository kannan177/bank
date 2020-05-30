package com.zoho.demorest;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("deposit")
public class DepositmoneytoUser {
	DBmanager dbManager = DBmanager.getInstance();
	
	
	@Path("amountadd")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	
public String depositAmount(@FormParam("t1") long Acc_No,
		
		@FormParam("t2") int amount)

{
		 if(dbManager.checkAvailable(Acc_No))
         {   
            
             dbManager.updateBalance(Acc_No, amount);
             return("Amount Deposite Successfuly ");
         }
         else
             return("You Are Not A Customer of in this Bank ");
}
	
}

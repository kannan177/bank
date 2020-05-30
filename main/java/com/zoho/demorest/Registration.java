package com.zoho.demorest;


import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("singup")
public class Registration {
	
	DBmanager dbManager = DBmanager.getInstance();
	@Path("registration")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	
public String register(@FormParam("Acc_No") Long Acc_No,
					   @FormParam("name") String userName,
					   @FormParam("password1") String Password,
					   @FormParam("password2") String Password1,
					   @FormParam("upi") int upi,
					   @FormParam("ph_no") Long phone)
{
		
			 if(dbManager.checkAvailable(Acc_No) && dbManager.checkname(userName,Acc_No))
			 {
				 
				 if(dbManager.checkOnlineAccess(Acc_No))
			        {
					 
					 	person pr=dbManager.getpersonInstnce();
             
					 	pr.setName(userName);
             
					 	pr.setAccountNumber(Acc_No);
             
					 	pr.setPassword(Password);
             
					 	pr.setUpi(upi);
             
					 	pr.setPhonenumber(phone);
             
					 	dbManager.updateUserDetails(pr);
             
					 	return "Online Access Granded";
					 	
			        }
				 
				 	else 
				 		return "You Have a Already Access";
              
			 }
			 else
				 return "You are Not a Customer of this Bank";
		
}

}

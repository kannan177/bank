package com.zoho.demorest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("creation")
public class Creation {
	DBmanager dbManager = DBmanager.getInstance();
	
	@Path("New_Account")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String newAccount(
			 @FormParam("phone_no") long phone_number,			
			 @FormParam("name") String name,
			 @FormParam("starting_balance") int balance)
	{
		DateTimeFormatter dtf = DateTimeFormatter . ofPattern ("yyyy/MM/dd");
        
        LocalDateTime now = LocalDateTime . now();
        dbManager.inserting(name,balance,( dtf.format (now) ),phone_number);
		return "new Acount is created";
	}
	
}

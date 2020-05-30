package com.zoho.demorest;

import java.sql.ResultSet;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/HistoryOfTransaction")
public class HistoryOfTransaction {

	DBmanager dbManager = DBmanager.getInstance();
	@Path("/HistoryOftransfer")
	@POST
	@Produces( MediaType .APPLICATION_JSON )
	
	public String HistoryOftransfer
	
	 	  ( @FormParam ("t1") String FromDate,
	 			  
			@FormParam("t2") String Todate )
	{
	   
		
		
	    ResultSet ws=null;
	    
		try 
		{
	        
			ws = dbManager.getHistory(FromDate, Todate);
			
			 dbManager . setHistoryClass ( ws );
			 
			  return "true";
		    
		} 
		catch (Exception e) 
		
		{
			
			return "false";
			
		}
		
	}
	
 
}
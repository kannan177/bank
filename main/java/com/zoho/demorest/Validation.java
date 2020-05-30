package com.zoho.demorest;



import java.net.URISyntaxException;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("validation")
public class Validation
{ 
	DBmanager DB = DBmanager.getInstance();
	
	@Path("checking")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces({MediaType.TEXT_PLAIN})
	
	public Response validation(@FormParam("t1") String Acc_No,
			
			@FormParam("t2") String Password) throws URISyntaxException
	
	{
		DBmanager DB = DBmanager.getInstance();
		
    	  if(DB.LogInvalidation(Long.parseLong(Acc_No), Password))
    		  
    	  {
    		  return Response.ok("true").build();
    		  
    	  }
    	  
    	  else
    		  
    		  return Response.ok("false").build();  	
	}	
	
}

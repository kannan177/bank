package com.zoho.demorest;

import java.net.URISyntaxException;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("employeeValidation")
public class EmployeeLogIn {
	
	
@Path("checking")
@POST
@Produces(MediaType.TEXT_PLAIN)

public Response validation(@FormParam("t1") long UserId ,
		@FormParam("t2") String Password)
{
	
	 DBmanager dbm = DBmanager . getInstance();

	 if( dbm.LogInvalidationEmp (UserId, Password) )
         
     { 
		 java.net.URI location = null;
		try {
			location = new java.net.URI("http://localhost:8083/demorest/EmployeeWelcome.jsp");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		  return Response.temporaryRedirect(location).build();
     } 
     else 
    	 return Response.ok("Please enter the correct value").build();
}

}

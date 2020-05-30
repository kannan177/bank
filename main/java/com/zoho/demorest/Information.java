package com.zoho.demorest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;


@Path("/information")
public class Information 
{
	
@Path("/balance")

@GET

public Response Balance()
	{	 
	 DBmanager db=DBmanager.getInstance();
	 
	 person pr = db.getpersonInstnce();
	 
	 return Response.ok(pr.getBalance()).build(); 
	 
	}

}


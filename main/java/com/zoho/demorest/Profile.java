package com.zoho.demorest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("profile")
public class Profile {

	@Path("myprofile")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public person profiledetails()
	{
		 DBmanager db=DBmanager.getInstance();
		 person pr = db.getpersonInstnce();
	   return pr;
	}
}

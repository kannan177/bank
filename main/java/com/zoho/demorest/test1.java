package com.zoho.demorest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/testing")
public class test1 {
	
@Path("/ongoing")
@POST
@Consumes("application/x-www-form-urlencoded")
@Produces(MediaType.TEXT_PLAIN)
public String tested(@FormParam ("t1") String t1,
		@FormParam("t2") String t2)
{
	System.out.println(t1+" "+t2);
	return "true";
}

}

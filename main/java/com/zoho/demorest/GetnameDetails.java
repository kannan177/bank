package com.zoho.demorest;


import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("getnameDetails")
public class GetnameDetails
{
	
	DBmanager dbManager = DBmanager.getInstance();	
	@Path("listByName")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public boolean listByName(@FormParam("name") String name)
	{
	
	  if(dbManager.checkname1(name))
	  {
		  return true;
	  }
	  return false;
	}
	
	@Path("list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<person> list()
	{
		ArrayList<person> list=dbManager.getPerson_Info_By_Name();
		return list;
	}
	
	
	@Path("listByOpeningDate")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public boolean listByOpeningDate(@FormParam ("from") String from,
			@FormParam("to") String to)
	{
	
	  try {
				if(dbManager.getListByOpeningDate(from, to))
				  {
					  return true;
				  }
	  	   } 
	  catch (SQLException e) 
	  {
		
		e.printStackTrace();
	  }
	  return false;
	}
	
	@Path("listByDate")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<person> listByDate()
	{
		ArrayList<person> list=dbManager.ListByDate();
		return list;
	}
	

}
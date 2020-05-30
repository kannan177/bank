package com.zoho.demorest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("LogOut")
public class LogOut {

@Path("CloseConnection")
@GET()
public boolean closeconnection()
{
	DBmanager.closeConnection();
	return true;
}
}

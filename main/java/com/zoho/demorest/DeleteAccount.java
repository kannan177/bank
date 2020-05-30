package com.zoho.demorest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("Delete")
public class DeleteAccount {
	
	@POST
	@Path("Remove")
	public String DEleteAccount(@FormParam ("t1") Long Acc_No)
	{
		DBmanager mn = DBmanager.getInstance();
		if(mn.DeleteAccount(Acc_No))
        {
			return "Deleted Sucessfully";
        }
		else
			return " Account is not valid ";
	}
}

package com.zoho.demorest;

import java.util.ArrayList;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/GetTransferList")
public class GetTransferList {

	
	@Path("getlist")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getList()
	{
		DBmanager db=DBmanager.getInstance();
		
		ArrayList<TransferHistory> history=null;
		
		history = db.getList();
		
		 return Response.ok(history).build(); 
	}
}
//var tbltop='<table><tr><th>receiver_accountno</th><th>sender_accountno</th><th>sender_name</th><th>receiver_name</th><th>amount</th><th>transactiondate</th></tr>';
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WelcomPage</title>
    </head>
    
    <script>
var baseurl='http://localhost:8083/demorest';

function CloseConnection()
{
	
	var xmlhttp = new XMLHttpRequest();

	xmlhttp.onreadystatechange=function()
	{
		
		if(xmlhttp.readyState == 4 && xmlhttp.status==200)
		{
			var response=this.responseText;	
			
			if(response=="true")
			{
			window.location.href="index.jsp";
			}
		}
		
	};
	xmlhttp.open("GET",baseurl+"/webapi/LogOut/CloseConnection",true);
	
	xmlhttp.send();
	
}
</script>
    
    <body>
        <h1>Hello </h1>
         <p>
        <a href="BalanceCheck.html">
            <button>Balance Check</button></a>
        </p>
        <br>
        <p>
        
        <a href="AmountTransfer.jsp">
        
            <button>Amount Transfser</button></a>
        </p>
        
        <p>
        
        <a href="TransactionDetails1.html">
        
            <button>Transaction History</button></a>
        </p>
        
        <br>
       <a href="ProfilePage.html">
        
            <button>profile</button></a>
        </p>
            
        </form>
        
        <br>
        
        <form method="post">
        
            <input type="submit" value="LogOut" onclick="CloseConnection()">
            
        </form>
        
        <br>
        <br>
        
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee-Welcome</title>
    </head>
    <body>
        <h1>Hello</h1>
        
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

        <table>
        <tr>
            <td>
                <a href="Get_CustomerList.jsp">
                <button>Get CustomerList</button></a>
            </td>
            <td>
                <a href="AmountDeposit.jsp">
                <button>Deposit money for user</button></a>
            </td>
        </tr>
        <tr>
        
            <td>
                
                <a href="Amou ntWithdraw.jsp">
                    
                <button>WithDraw money for user</button></a>
                
            </td>
            
            <td>
                
            <a href="MoneyTransfer.jsp">
                
                <button>Transfer money for user</button></a>
                
            </td>
            
        </tr>
        <br>
        
        <tr>
        <td>
        <a href="CreateNewUser.jsp">
            <button>Add new user</button></a>
        </td>
        <br>
          <td>
        <a href="DeleteAccount.jsp">
            <button>Remove user</button></a>
        </td>
        </tr>
        <tr>
        <td>
        <form>
        
            <input type="submit" value="LogOut" onclick="CloseConnection()">
            
        </form><br>
        </td>
        </tr>
            <br>
        </table>
    </body>
</html>
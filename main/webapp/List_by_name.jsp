<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <script>
            function lettersonly(input)
            {
         		 var regex =/[^a-z]/gi;
         		 input.value=input.value.replace(regex,"");
      		} 
            
            function getList()
            
            {  
            	
            	var baseurl='http://localhost:8083/demorest';
            	
            	var t1= document.getElementById("name").value;
            	           	            	                        	
            	var xmlhttp = new XMLHttpRequest();            	
            
            	xmlhttp.onreadystatechange=function()
            	{
            		
            		if(xmlhttp.readyState == 4 && xmlhttp.status==200)
            			
            		{	
            			
            			var response=this.responseText;	
            			
            			if(response=="true")
            			{ 
            			
            				window.location.href="GetListByName.html";
            			}
            			else
            				alert("Please enter the correct name");
            		}            		
            		
            	};
            	
            	xmlhttp.open("POST",baseurl+"/webapi/getnameDetails/listByName",true);
            	
            	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            	
            	xmlhttp.send("name="+t1);
            }
     		
   </script>
        
   <body>
   
            <form method="post">
            
                Enter the name <input type ="text" id ="name" onkeyup="lettersonly(this)" required>    
                           
            <br>
            
            <input type ="submit" onclick="getList()">
            
            </form>
            
            </body>
</html>
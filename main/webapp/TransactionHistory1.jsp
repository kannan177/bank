<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Java Date Picker</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker({ dateFormat: "yy/mm/dd" }).val();
                $("#datepicker1").datepicker({ dateFormat: "yy/mm/dd" }).val();
            });
            
            function getList()
            
            {  
            	
            	var baseurl='http://localhost:8083/demorest';
            	
            	var t1= document.getElementById("datepicker").value;
            	
            	var t2= document.getElementById("datepicker1").value;   	
            	
            	var xmlhttp = new XMLHttpRequest();            	
            
            	xmlhttp.onreadystatechange=function()
            	{
            		
            		if(xmlhttp.readyState == 4 && xmlhttp.status==200)
            			
            		{	
            			
            			var response=this.responseText;	
            			
            			if(response=="true")
            			{ 
            			
            				window.location.href="GetListByDate.html";
            			}
            			else
            				alert("Please enter the correct date ");
            		}            		
            		
            	};
            	
            	xmlhttp.open("POST",baseurl+"/webapi/getnameDetails/listByOpeningDate",true);
            	
            	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            	
            	xmlhttp.send("from="+t1+"&to="+t2);
            }
     		
   </script>
            
            
        </script>
    </head>
    <body>
        <Pre>
        <form  method="post">
        
            <label for="datepicker">Enter from date:</label>
            
            <input type="text" name="from" id="datepicker" required>
            
            <label for="datepicker">Enter to date:</label>
            
            <input type="text" name="to" id="datepicker1" required><br>
            
            <input type="submit" value="Submit" onclick="getList()">
            
        </form>
        </pre>    
    </body>

</html>
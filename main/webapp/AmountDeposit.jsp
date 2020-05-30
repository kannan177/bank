<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Amount Deposit Page</title>
     </head>
             
     <script>
            function numbersonly(input){
          var regex =/[^0-9]/gi;
          input.value=input.value.replace(regex,"");
      }    
      </script>
           
      <body>
      
        <form action ="webapi/deposit/amountadd" method="post">
        
            <lable>Enter the Account Number</lable><input type="text" name="t1"  onkeyup="numbersonly(this)" required>
            
            <lable>Enter the Amount</lable><input type="text" name="t2"  onkeyup="numbersonly(this)" required>
            
            <input type ="submit" value="ok">
            
        </form>
        <br><br>
                 <a href= EmployeeWelcome.jsp><button>back</button></a>
    </body>
    
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
     <title>User Login Page</title>
     <script>
            function numbersonly(input){
          var regex =/[^0-9]/gi;
          input.value=input.value.replace(regex,"");
      } 
        </script>
        
        
            <body>
            <form action ="webapi/employeeValidation/checking" method="post">
                Enter the LogIn ID   <input type ="text" name ="t1" onkeyup="numbersonly(this)" required>
            <br>Enter the Password   <input type ="password" name ="t2"  required>
            <br>
            <input type ="submit" value="Log In">
            </form>
                <br><br>
                 <a href= index.html><button>back</button></a>
            </body>
</html>
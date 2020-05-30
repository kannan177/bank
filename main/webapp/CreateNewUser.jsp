<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
    </head>
    <script> 
        function numbersonly(input){
          var regex =/[^0-9]/gi;
          input.value=input.value.replace(regex,"");
        }
        function lettersonly(input){
          var regex =/[^a-z]/gi;
          input.value=input.value.replace(regex,"");
        }
        
        </script>
    <body>
        <form action ="webapi/creation/New_Account" method="post">
            <br><lable for="name"><b> Name</b></lable> <input type ="text" name ="name" onkeyup="lettersonly(this)" required><br><br>
            <lable for="Acc_No"><b>Initial Balance</b> </lable>  <input type ="text" name ="starting_balance" onkeyup="numbersonly(this)" required><br>
                                       <br><lable for="phone_no"><b>Phone Number </b></lable> <input type ="text" name ="phone_no" onkeyup="numbersonly(this)" required><br><br>
                                       <input type ="submit" value="Register"><br><br>
        </form>
        <a href= EmployeeWelcome.jsp><button>back</button></a>
    </body>
</html>
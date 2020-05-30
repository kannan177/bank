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
        <form onSubmit = "return checkPassword(this)" action ="webapi/Employee_Money_Transfer/transfer" method="post">
            <lable for="t1"><b>Sender Account No</b> </lable>  <input type ="text" name ="t1" onkeyup="numbersonly(this)" required><br>
            <br><lable for="t2"><b> Receiver Account No</b></lable> <input type ="text" name ="t2" onkeyup="numbersonly(this)" required><br>
                         <br> <lable for="receiver"><b>Receiver_name</b></lable><input type ="text" name ="receiver" onkeyup="lettersonly(this)" required><br>
                         <br> <lable for="receiver"><b>Sender_name</b></lable><input type ="text" name ="sender" onkeyup="lettersonly(this)" required><br>
                                   <br><lable for="t3"><b>Amount </b></lable> <input type ="text" name ="t3" onkeyup="numbersonly(this)" required><br><br>
                                       <input type ="submit" value="send"><br><br>
        </form>
    </body>
     <a href= Welcom.jsp>back</a>
</html>

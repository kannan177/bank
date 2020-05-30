<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <form action ="webapi/Delete/Remove" method="post">
                Enter the Acc_No  <input type ="text" name ="t1" onkeyup="numbersonly(this)" required>
            <br>
            <input type ="submit" value="Delete">
            </form>
        <br><br> <a href= EmployeeWelcome.jsp> back </a>
    </body>
</html>
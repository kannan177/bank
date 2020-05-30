<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Sign Up</title>
        
    </head>
    
    <script>
        function checkPassword(form) { 
        	
                password1 = form.password1.value; 
                
                password2 = form.password2.value; 
                
                 if (password1 != password2) { 
                	 
                    alert ("\nPassword did not match: Please try again...") 
                    
                    return false; 
                    
                     }  
                 
                else{ 
                	
                    alert("Password Match: Welcome to OnlineBanking!") 
                    
                    return true; 
                } 
            } 
        function numbersonly(input){
        	
          var regex =/[^0-9]/gi;
          
          input.value=input.value.replace(regex,"");
          
        }
        
        function lettersonly(input){
        	
          var regex =/[^a-z]/gi;
          
          input.value=input.value.replace(regex,"");
          
        }
        
        </script>
        
<style>
        .container {
  padding: 16px;
  background-color: white;
        }
        .signin {
  background-color: #f1f1f1;
  text-align: center;
}       
</style>
    <body>
        <form onSubmit = "return checkPassword(this)" action ="webapi/singup/registration" method="post">
        
            <lable for="Acc_No"><b>Enter Account No</b> </lable>  <input type ="text" 
            
            				name ="Acc_No" onkeyup="numbersonly(this)" required><br>
            
            <br><lable for="name"><b>Account Holder Name</b></lable> <input type ="text" 
            
                            name ="name" onkeyup="lettersonly(this)" required><br>
                                         
           <br> <lable for="password1"><b>Password</b></lable><input type ="password" 
                         
                            name ="password1" required><br>
                         
           <br><lable for="password2"><b>Confirm Password </b></lable> <input type ="password" 
                              
                            name ="password2" required><br>
                              
           <br><lable for="upi"><b>Set UPI Number </b></lable> <input type ="password" 
                                   
                            name ="upi" onkeyup="numbersonly(this)" required><br><br>
              
           <br><lable for="ph_no"><b>Phone Number </b></lable> <input type ="text" 
                                       
                           name ="ph_no" onkeyup="numbersonly(this)" required><br><br>
                                       
          <input type ="submit" value="Register">
          
        </form>
        
         <a href= index.jsp><button>back</button></a>
    </body>
</html>
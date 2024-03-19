<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Login Page</title>
</head>
<body>
    <h1>Login</h1>
    <form method="POST" action="login">
        <label for="login_id">login_id:</label>
        <input type="text" id="login_id" name="login_id"><br>
        <label for="login_pw">login_pw:</label>
        <input type="password" id="login_pw" name="login_pw"><br>
        <input type="submit" value="Login">
    </form>

    <p>or <a href="createuser">Create User</a></p>
    
    <%  
    String Message=(String)request.getAttribute("Message");
    if(Message!=null){
    %>
    <p class="error_msg" style="text-weight: bold; font-size:30px; color:red;"> <%= Message %> <p>
    <% } %>
</body>
</html>
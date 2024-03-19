<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
<meta charset="UTF-8">
<title>Create user account</title>
</head>
<body>
    <h1>Create</h1>
    <form method="POST" action="createuser">
        <label for="name">name:</label>
        <input type="text" id="name" name="name"><br>
        <label for="login_id">login_id:</label>
        <input type="text" id="login_id" name="login_id"><br>
        <label for="login_pw">login_pw:</label>
        <input type="password" id="login_pw" name="login_pw"><br>
        <input type="submit" value="Create">
    </form>
</body>
</html>
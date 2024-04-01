<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo App - Confirm - </title>
    <link rel="stylesheet" type="text/css" href="/TodoApp/styles/style.css">
</head>
<body>

<div class="total_box">
    <header>Confirm</header>
    <main>
        <% String type=(String)request.getAttribute("type");%>
        <div class="content_box">
            <div class="input_box">
            	<div class="result_box">
                <%  if (type.equals("create")){
                String message = (String)request.getAttribute("message");
                Integer user_id = (Integer)request.getAttribute("user_id");
                String title = (String)request.getAttribute("title");
                String content = (String)request.getAttribute("content");  
                %>
                <%= message %> <%=type %><br>
                user_id : <%= user_id %><br>
                title: <%= title %> <br>
                content: <%= content %> <br>
                <%} %>
                
                <%  if (type.equals("delete")){
                String message = (String)request.getAttribute("message");%><br>
				<% Integer id = (Integer)request.getAttribute("user_id");
                %>
                <%= message %> <%=type %><br>
                <%} %>
                
                <%  if (type.equals("edit")){
                String message = (String)request.getAttribute("message");%><br>
				<% Integer id = (Integer)request.getAttribute("user_id");
                %>
                <%= message %> <%=type %><br>
                <%} %>
                </div>
                
                
                <form action="home" method="get">
                    <button type="submit" class="btn_1">Return</button>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
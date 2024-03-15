<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="/TodoApp/styles/style.css">
<title>Todo App - CREATE - </title>
</head>
<body>
<div class="total_box">
	<header>Create todo</header>
	<main>
		
		<form action="create" method="post">
		<div class="content_box">
		- input
		<div class="input_box">
		<label for="user_id"> user_id:</label> <input type="text" name="user_id" value='1' class="input_id_box"> <br>
		<label for="title"> title </label> <br>
		<input type="text" name="title" value='Input the title' class="input_title_box"><br>
		<label for="content"> content </label> <br>
		<input type="text" name="content" value='Input the contents' class="input_contents_box"> <br>		
		</div>
	    
 			<div class="btn_box">
					<button type="submit" class="btn_1"> Create </button> 
					<a href="home"> <span class="btn_2"> Return </span> </a>
			</div>
		</div>
		</form>
	
	
	</main>
	</div>
		
</body>
</html>
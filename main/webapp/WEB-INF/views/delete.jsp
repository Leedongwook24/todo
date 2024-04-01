<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="/TodoApp/styles/style.css">
<title>Todo App - DELETE/EDIT -</title>
</head>
<body>
<div class="total_box">
	<header>Delete/Edit todo</header>
	<main>
		
		<div class="content_box">
		- Delete
		<form action="delete" method="post">
		<div class="input_box">
		<label for="id">id:</label> <input type="text" name="id" value='1' class="input_id_box"> <br>
		<div class="btn_box1">
		<button type="submit" class="btn_1"> Delete </button> 
		<a href="home"> <span class="btn_2"> Return </span> </a>
		</form>
		</div>
		</div>


		<div class="content_box">
		-Edit		
		<form action="edit" method="post">
		<div class="input_box">
		<label for="id">id:</label> <input type="text" name="id" value='1' class="input_id_box"> 
		<label for="user_id"> user_id:</label> <input type="text" name="user_id" value='1' class="input_id_box"> <br>
		<label for="title"> title </label> <br>
		<input type="text" name="title" value='Input the title' class="input_title_box"><br>
		<label for="content"> content </label> <br>
		<input type="text" name="content" value='Input the contents' class="input_contents_box"> <br>
		<div class="btn_box1">
		<button type="submit" class="btn_1"> Edit </button> 
		<a href="home"> <span class="btn_2"> Return </span> </a>
		</div>
		</form>
		</div>
	
	
	</main>

</body>
</html>
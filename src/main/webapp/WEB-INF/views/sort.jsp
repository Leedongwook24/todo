<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo App - Sort - </title>
    <link rel="stylesheet" type="text/css" href="/TodoApp/styles/style.css">
</head>
<body>

<div class="total_box">
    <header>Sort</header>
    <main>
        <div class="content_box">
         -Sort
            <div class="input_box">
            	<div class="result_box">
            		<form action="home" method="post">
            			<input type="hidden" name="message" value="sort">
            			<label for="sort_type"> Sort_type:</label>
            			<select name="sort_type" id="sort_type">
            			    <option value="id"> id</option>
            			 	<option value="create_date"> Date </option>
            			 	<option value="user_id"> user_id </option>
            			 	<option value="priority"> priority </option>
            			</select> 
            				<br><br>
	           			<label for="asc_or_desc"> Order:</label>
            			<select name="asc_or_desc" id="asc_or_desc">
            			    <option value="ASC">  ascending order</option>
            			 	<option value="DESC">descending order  </option>
            			</select> <br>
            			<div class="btn_box1">
            			<button type="submit" class="btn_1">Sort</button>
            			</div>
                </div>              
                	</form>
                <form action="home" method="get">
          			<div class="btn_box1">   			
                    <button type="submit" class="btn_2">Return</button>
					</div>
                </form>
                 
            </div>
        
        </div>
    </main>
</body>
</html>
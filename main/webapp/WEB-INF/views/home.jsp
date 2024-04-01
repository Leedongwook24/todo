<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/TodoApp/styles/style.css">

<title>Todo App - TOP -</title>
</head>
<body>
	<div class="total_box">
		<header>Todo List</header>
		<main>
			<div class="content_box">

				-
				<%=session.getAttribute("name")%>'s ToDo List
				<div class="list_box">
					<table>
						<th class="column_name_box" id="1">Id</th>
						<th class="column_name_box" id="2">Title</th>
						<th class="column_name_box" id="3">Contents</th>
						<th class="column_name_box" id="4">Date</th>
						<th class="column_name_box" id="1">Priority</th>

						<%
						ArrayList<HashMap<String, String>> rows = (ArrayList<HashMap<String, String>>) request.getAttribute("rows");
						%>
						<%
						for (HashMap<String, String> columns : rows) {
						%>
						<tr>
							<td class="column_content_box"><%=columns.get("id")%></td>
							<td class="column_content_box"><%=columns.get("title")%></td>
							<td class="column_content_box"><%=columns.get("content")%></td>
							<td class="column_content_box"><%=columns.get("create_date")%></td>
							<td class="column_content_box"><%=columns.get("priority")%></td>
						</tr>
						<%
						}
						%>

					</table>
				</div>

				- Modify
				<div class="btn_box">
					<div class="btn_1">
						<a href='create'> Create </a>
					</div>
					<div class="btn_2">
						<a href='todelete'> Delete/Edit </a>
					</div>
					<div class="btn_1">
						<a href='tosort'> Sort </a>
					</div>
					<div class="btn_2">
						<a href='logout'> Logout </a>
					</div>
				</div>
			</div>



		</main>
	</div>

</body>
</html>
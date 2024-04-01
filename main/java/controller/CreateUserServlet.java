package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/createuser")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// db(todo_kadai)에 접속하기 위한 정보 
    private static final String DB_URL = "jdbc:mysql://localhost:3306/todo_kadai";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
// doGet으로 접속시 createuser.jsp로 이동	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="/WEB-INF/views/createuser.jsp";
		request.getRequestDispatcher(view).forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// login.jsp로부터 namw, id, pw를 변수 name, login_id, login_pw에 저장;
			String name = request.getParameter("name");
			String login_id = request.getParameter("login_id");
			String login_pw = request.getParameter("login_pw");
	// JDBC의 드라이버를 로드 
			try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch(Exception e){
	        e.printStackTrace();
	    }
				// DB에 DB_URL,DB_USER,DB_PASSWORD를 사용하여 접속한다.
				try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD))
				{
		String sql="INSERT INTO user_list (name, login_id, login_pw) value (?,?,?)";
		try(PreparedStatement stmt= conn.prepareStatement(sql)){
			stmt.setString(1, name);
			stmt.setString(2, login_id);
			stmt.setString(3, login_pw);
			stmt.execute();
			String view="WEB-INF/views/login.jsp";
			request.setAttribute("Message", "アカウント作成に成功しました。");
			request.getRequestDispatcher(view).forward(request, response);
		}
	}	catch(SQLException e) {
		e.printStackTrace();
		throw new ServletException("Database Connection Failed", e);
	}   
//		catch(NoSuchAlgorithmException e) {
//		e.printStackTrace();
//		throw new ServletException("Generate hash Failed", e);	}

	}
}
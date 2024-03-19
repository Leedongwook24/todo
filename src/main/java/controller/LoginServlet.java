package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
// db(todo_kadai)에 접속하기 위한 정보 
    private static final String DB_URL = "jdbc:mysql://localhost:3306/todo_kadai";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
// doGet으로 접속시 login.jsp로 이동	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String view="WEB-INF/views/login.jsp";
			request.getRequestDispatcher(view).forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// login.jsp로부터 id와 비밀번호를 변수 username, password에 저장;
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
// 굳이 HASHED PASSWORD를 사용하지는 않는다.
//		String hashedPassword = HashGenerator.generateHash(password);
		String sql="SELECT * FROM user_list WHERE login_id=? AND login_pw = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1, login_id);
				stmt.setString(2, login_pw);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
// 보내는 건 id와 name 만 있으면 된다.
					int id = rs.getInt("id");
					String name=rs.getString("name");
					HttpSession session = request.getSession();
					session.setAttribute("id",id);
					session.setAttribute("name", name);
// home
					response.sendRedirect("home");					
					} else {
// 로그인 실패시 에러 메세지 출력
					String view ="/WEB-INF/views/login.jsp";
					request.setAttribute("Message","id 又は pwが一致しません。" );
					request.getRequestDispatcher(view).forward(request,response);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServletException("Database Connection Failed", e);
			} 
// 암호화 알고리즘을 사용한 경우
			/*catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				throw new ServletException("Generate hash Failed", e);
			}*/

		
	}
//
	
	
	
	
}

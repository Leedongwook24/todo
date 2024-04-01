package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createServlet
 */
@WebServlet("/create")
public class createServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 	   String view ="WEB-INF/views/create.jsp";
	 	   RequestDispatcher dispatcher= request.getRequestDispatcher(view);
	 	   dispatcher.forward(request,response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String create_date="";
        if(request.getAttribute("message")==null){
            request.setAttribute("message", "Title"); 
        }
           int user_id= Integer.parseInt(request.getParameter("user_id"));
		   String title= request.getParameter("title");
		   String content= request.getParameter("content");

	        String url = "jdbc:mysql://localhost:3306/todo_kadai";
	        String user = "root";
	        String password ="password";
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch(Exception e){
	            e.printStackTrace();
	        }
	        String sql = "INSERT INTO todo_list (user_id, title, content, create_date,status) VALUES (?,?,?,?,?)";
	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             PreparedStatement statement = connection.prepareStatement(sql);){
	            statement.setInt(1, user_id);
	            statement.setString(2, title);
	            statement.setString(3, content);
	            LocalDateTime currentDateTime = LocalDateTime.now();
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	            create_date=currentDateTime.format(formatter);
	            statement.setString(4, create_date);
	            statement.setString(5, "In_Progress");
	            statement.executeUpdate();
	        } catch(SQLException e){
	            e.printStackTrace();
	        }
		   
	        request.setAttribute("message", "New Data Applied Successfully");
	    	request.setAttribute("type", "create");
	        request.setAttribute("user_id", user_id);
	        request.setAttribute("title", title);
	        request.setAttribute("content", content);
	        request.setAttribute("create_date", create_date);
	        
	        
		 	   String view ="WEB-INF/views/confirm.jsp";
		 	   RequestDispatcher dispatcher= request.getRequestDispatcher(view);
		 	   dispatcher.forward(request,response);
	}
}

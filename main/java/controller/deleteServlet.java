package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(request.getAttribute("message")==null){
            request.setAttribute("message", "Title"); 	}
		 	int id = Integer.parseInt(request.getParameter("id"));
			String url = "jdbc:mysql://localhost:3306/todo_kadai";
		    String user = "root";
		    String password ="password";
		    try{
		        Class.forName("com.mysql.cj.jdbc.Driver");
		    } catch(Exception e){
		        e.printStackTrace();
		    }	 
		    String sql ="DELETE FROM todo_list WHERE id = ?";
		    try (Connection connection = DriverManager.getConnection
			        (url, user, password);
			       PreparedStatement statement = connection.prepareStatement(sql);)
		    { 	statement.setInt(1, id); 
		    	int number = statement.executeUpdate();
		    	request.setAttribute("message", "Deleting data finished successfully where id:"+id);
		    	request.setAttribute("type","delete");
		    }    catch(SQLException e){
		        e.printStackTrace();
		    }
		    String forward="WEB-INF/views/confirm.jsp";
		    RequestDispatcher dispatcher= request .getRequestDispatcher(forward);
		    dispatcher.forward(request, response);
		    
		    
		    
	}

}

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
 * Servlet implementation class editServlet
 */
@WebServlet("/edit")
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editServlet() {
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
            request.setAttribute("message", "Title"); }
        int id = Integer.parseInt(request.getParameter("id"));
        int user_id=Integer.parseInt(request.getParameter("user_id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        String url = "jdbc:mysql://localhost:3306/todo_kadai";
        String user = "root";
        String password ="password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e){
            e.printStackTrace();
        }
        String sql ="UPDATE todo_list SET user_id = ?, title = ?, content = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection
    	        (url, user, password);
    	        PreparedStatement statement = connection.prepareStatement(sql);)
        { 	statement.setInt(1,user_id);
    		statement.setString(2,title);
    		statement.setString(3,content);
    		statement.setInt(4, id);
    	int number = statement.executeUpdate();
	    request.setAttribute("message", "Update finished succeesfully where id:"+id);
	    request.setAttribute("type","edit"); 
    }
    catch(SQLException e){
        e.printStackTrace();
    }
    catch(Exception e) {
    	request.setAttribute("message", "Exception" + e.getMessage());
    }
           
    String forward="WEB-INF/views/confirm.jsp";
    RequestDispatcher dispatcher= request .getRequestDispatcher(forward);
    dispatcher.forward(request, response);    
        
	}
}

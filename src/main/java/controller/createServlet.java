package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CreateDAO;

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
		   try {
			  CreateDAO dao = new CreateDAO();
			  dao.Insert(user_id, title, content);
		   } catch(SQLException e) {
			   System.out.println("SQL 예외 발생: " + e.getMessage());
			   e.printStackTrace();
		   } catch(Exception e) {
			   request.setAttribute("message", "例外発生");
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

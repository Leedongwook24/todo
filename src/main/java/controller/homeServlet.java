package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListDAO;
import dao.SortDAO;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/home")
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 if(request.getAttribute("message")==null){
	            request.setAttribute("message", ""); 
	        }
	       try {

	    	   
	    	   HttpSession session = request.getSession();
	    	   int id = (Integer)session.getAttribute("id");	    	   
	    	   ListDAO dao = new ListDAO();
	    	   request.setAttribute("rows", dao.select(id));
	       } catch (SQLException e) {
	    	   e.printStackTrace();
	       } catch (Exception e) {
	    	   request.setAttribute("message","例外発生");
	       }

	   
 	   String view ="WEB-INF/views/home.jsp";
 	   RequestDispatcher dispatcher= request.getRequestDispatcher(view);
 	   dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("sort_type")!=null) 
		{
			String sort_type=request.getParameter("sort_type");
			String asc_or_desc=request.getParameter("asc_or_desc");
		       try {
		    	   HttpSession session = request.getSession();
		    	   int id =(Integer)session.getAttribute("id");
		    	   SortDAO dao = new SortDAO();
		    	   request.setAttribute("rows", dao.select(id, sort_type, asc_or_desc));
		       } catch (SQLException e) {
		    	   e.printStackTrace();
		       } catch (Exception e) {
		    	   request.setAttribute("message","例外発生");
		       }
	        String view="WEB-INF/views/home.jsp";
	        RequestDispatcher dispatcher= request .getRequestDispatcher(view);
	        dispatcher.forward(request, response);
		} 
		else{doGet(request, response);}
	}

}

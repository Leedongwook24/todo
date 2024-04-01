package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EditDAO;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/edit_or_delete")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "WEB-INF/views/delete.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getAttribute("message") == null) {
			request.setAttribute("message", "Title");
		}
		int id = Integer.parseInt(request.getParameter("id"));
		EditDAO dao = new EditDAO();
		try {
			if (request.getParameter("delete_trigger") != null) {
				dao.Delete(id);
			} else {
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				dao.UPDATE(id, user_id, title, content);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("message", "例外発生");
		}

		
		if (request.getAttribute("delete_trigger") != null) {
			request.setAttribute("message", "Deleting data finished successfully where id:" + id);
			request.setAttribute("type", "delete");
		} else {
			request.setAttribute("message", "edit data finished successfully where id:" + id);
			request.setAttribute("type", "edit");
		}

		String forward = "WEB-INF/views/confirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);

	}

}

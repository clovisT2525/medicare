package service;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tag;

public class AddTag extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final Database database = new Database();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");

		if (database.addTag(new Tag(name))) {
			out.print("Tag added successfully");
		} else {
			out.print("Error occurred.");
		}

		RequestDispatcher rd = request.getRequestDispatcher("adminMenu.jsp");
		rd.forward(request, response);

		out.close();
	}
}

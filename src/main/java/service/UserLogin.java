package service;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Database database = new Database();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("userpass");
		
		int loginResponse = database.verifyLogin(username, password);
		if (loginResponse == 2) {
			response.sendRedirect("adminMenu.jsp");
		} else if(loginResponse == 1) {
			response.sendRedirect("userMenu.jsp");
		} else {
			out.print("Entered Credentials are incorrect.");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}

		out.close();
	}

}

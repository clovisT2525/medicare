package service;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Offer;

public class AddOffer extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final Database database = new Database();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		Integer valueInDiscount = Integer.valueOf(request.getParameter("value_in_discount"));
		
		if (database.addOffer(new Offer(name, valueInDiscount))) {
			out.print("Offer added successfully");
		} else {
			out.print("Error occurred.");
		}

		RequestDispatcher rd = request.getRequestDispatcher("adminMenu.jsp");
		rd.include(request, response);

		out.close();
	}
}

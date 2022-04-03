package service;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Medicine;

public class AddMedicine extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final Database database = new Database();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int price = Integer.valueOf(request.getParameter("price"));
		int sellerId = Integer.valueOf(request.getParameter("seller"));
		int tagId = Integer.valueOf(request.getParameter("tag"));
		int offerId = Integer.valueOf(request.getParameter("offer"));
		String isActiveString = request.getParameter("active");
		String imgUrl = request.getParameter("imageUrl");
		boolean isActive;
		if(isActiveString==null) {
			isActive=false;
		}else {
			isActive=true;
		}
		if (database.addMedicine(new Medicine(name,description,sellerId,price,offerId,tagId,isActive,imgUrl))) {
			out.print("Medicine added successfully");
		} else {
			out.print("Error occurred.");
		}

		RequestDispatcher rd = request.getRequestDispatcher("adminMenu.jsp");
		rd.include(request, response);

		out.close();
	}
}

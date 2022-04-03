package service;
import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

public class ChooseMedicine extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Database database = new Database();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<Integer, Medicine> medicineMap = database.getAllMedicines();
		Map<Integer, Tag> tagMap = database.getAllTags();
		Map<Integer, Offer> offerMap = database.getAllOffers();
		Map<Integer, Seller> sellerMap = database.getAllSellers();
		
		response.setContentType("text/html");

		Integer choice = Integer.valueOf(request.getParameter("chosenMedicine"));

		RequestDispatcher rd = request.getRequestDispatcher("/adminMenu.jsp");
		rd.include(request, response);
		request.setAttribute("tagMap", tagMap);
		request.setAttribute("offerMap", offerMap);
		request.setAttribute("sellerMap", sellerMap);
		request.setAttribute("choice", choice);
		request.setAttribute("medicineMap", medicineMap);
		RequestDispatcher changePasswordDispatcher = request.getRequestDispatcher("/editMedicineDetail.jsp");
		changePasswordDispatcher.forward(request, response);
	}

}

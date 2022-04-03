package service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Medicine;
import model.Offer;
import model.Seller;
import model.Tag;  


public class DisplayCart extends HttpServlet {

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

		String cart=request.getParameter("cart");
		
		JsonObject jsonObject = new JsonParser().parse(cart).getAsJsonObject();
		JsonElement cartObject = jsonObject.get("cart");
		Map<Integer,Integer> medicineQuantityMap = new HashMap<Integer,Integer>();
		
		for(Map.Entry<String, JsonElement> entry : ((JsonObject) cartObject).entrySet()) {
		    medicineQuantityMap.put(Integer.valueOf(entry.getKey()), entry.getValue().getAsInt());
		}
		
		request.setAttribute("tagMap", tagMap);
		request.setAttribute("offerMap", offerMap);
		request.setAttribute("sellerMap", sellerMap);
		request.setAttribute("medicineMap", medicineMap);
		request.setAttribute("medicineQuantityMap", medicineQuantityMap);
		request.setAttribute("cart", cart);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/displayCart.jsp");
		dispatcher.forward(request, response);

	}
}

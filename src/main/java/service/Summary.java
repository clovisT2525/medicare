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


public class Summary extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Database database = new Database();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<Integer, Medicine> medicineMap = database.getAllMedicines();
		
		response.setContentType("text/html");

		String cart=request.getParameter("cartInfo");
		String paymentMethod=request.getParameter("adminOption");
		
		JsonObject jsonObject = new JsonParser().parse(cart).getAsJsonObject();

		JsonElement cartObject = jsonObject.get("cart");
		int totalAmount = jsonObject.get("totalAmount").getAsInt();
		
		
		Map<Integer,Integer> medicineQuantityMap = new HashMap<Integer,Integer>();
		
		for(Map.Entry<String, JsonElement> entry : ((JsonObject) cartObject).entrySet()) {
		    medicineQuantityMap.put(Integer.valueOf(entry.getKey()), entry.getValue().getAsInt());
		}

		
		request.setAttribute("medicineMap", medicineMap);
		request.setAttribute("totalAmount", totalAmount);
		request.setAttribute("medicineQuantityMap", medicineQuantityMap);
		request.setAttribute("paymentMethod", paymentMethod);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/summary.jsp");
		dispatcher.forward(request, response);

	}
}

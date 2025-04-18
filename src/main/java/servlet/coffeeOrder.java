package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class coffeeOrder
 */
@WebServlet("/coffeeOrder")
public class coffeeOrder extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 接收參數
		// 例如: http://localhost:8080/JavaWeb/welcome?name=Jack&age=17
		String type = request.getParameter("type");
		String size = request.getParameter("size");
		String sugar = request.getParameter("sugar");

		String sizeconvert = convertSizeString(size);
		String sugarconvert = convertsugarString(sugar);
		
		 Map<String, Map<String, Integer>> coffeePrices = new HashMap<>();

	        coffeePrices.put("Latte", Map.of(
	            "S", 50,
	            "M", 70,
	            "L", 90
	        ));

	        coffeePrices.put("Mocha", Map.of(
	            "S", 45,
	            "M", 55,
	            "L", 65
	        ));

	        coffeePrices.put("Americano", Map.of(
	            "S", 40,
	            "M", 45,
	            "L", 60
	        ));

	        coffeePrices.put("Cappuccino", Map.of(
	            "S", 55,
	            "M", 80,
	            "L", 100
	        ));
	        
	        int price=coffeePrices.get(type).get(size);

		String resultString = "您點了一杯".concat(sizeconvert).concat(type).concat("咖啡 (").concat(sugarconvert).concat(") 價格").concat(String.valueOf(price));

//		response.getWriter().print(resultString);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/coffee_order.jsp");
		request.setAttribute("sizeconvert", sizeconvert);
		request.setAttribute("type", type);
		request.setAttribute("sugarconvert", sugarconvert);
		request.setAttribute("resultString", resultString);
		rd.forward(request, response);
	}

	private static String convertSizeString(String size) {
		switch (size) {
		case "S": {
			size = "小杯";
			break;
		}
		case "M": {
			size = "中杯";
			break;
		}
		case "L": {
			size = "大杯";
			break;
		}

		}
		return size;
	}

	private String convertsugarString(String sugar) {
		switch (sugar) {
		case "yes": {
			sugar = "加糖";
			break;
		}
		case "no": {
			sugar = "無糖";
			break;
		}

		}
		return sugar;
	}
}

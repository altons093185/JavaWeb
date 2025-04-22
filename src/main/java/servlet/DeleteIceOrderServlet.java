package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ice.IceOrder;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class DeleteIceOrderServlet
 */
@WebServlet("/deleteIceOrder")
public class DeleteIceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<IceOrder> iceOrders = IceDessertServlet.getIceOrders();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("iceOrders", iceOrders); // 把最新清單塞進 request
		request.getRequestDispatcher("/WEB-INF/ice_dessert_result.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String indexStr = request.getParameter("index");

		boolean success = false;
		try {
			int index = Integer.parseInt(indexStr);
			if (index >= 0 && index < iceOrders.size()) {
				iceOrders.remove(index);
				success = true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);

	}
}
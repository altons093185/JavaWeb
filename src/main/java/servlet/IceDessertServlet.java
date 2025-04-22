package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ice.IceOrder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Servlet implementation class IceDessertServlet
 */
@WebServlet("/ice")
public class IceDessertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static List<IceOrder> iceOrders = new CopyOnWriteArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/ice_dessert_form.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 接收表單參數
		String mainDishName = request.getParameter("mainDish");
		String[] toppingArray = request.getParameterValues("toppings");
		// 建立 IceOrder
		IceOrder iceOrder = new IceOrder(mainDishName, toppingArray);
		// 加入到訂單集合
		iceOrders.add(iceOrder);
		// 重導到 jsp
		request.setAttribute("iceOrders", iceOrders);
		request.getRequestDispatcher("/WEB-INF/ice_dessert_result.jsp").forward(request, response);
	}

	public static List<IceOrder> getIceOrders() {
		// TODO Auto-generated method stub
		return iceOrders;
	}

}

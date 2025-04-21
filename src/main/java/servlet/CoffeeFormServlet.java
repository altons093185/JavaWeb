package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CoffeeForm;
import model.User;

import java.io.IOException;

/**
 * Servlet implementation class CoffeeFormServlet
 */
@WebServlet("/CoffeeForm")
public class CoffeeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/coffee_form.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收表單資料
		// 請求編碼
		request.setCharacterEncoding("UTF-8");
		// 接收參數
		
		// 2.接收參數
		String milkAmount = request.getParameter("milk");
		String coffeeAmount = request.getParameter("coffee");
		
		// 3.將參數資料注入到 Model 中(User.java)
		CoffeeForm coffee = new CoffeeForm(milkAmount, coffeeAmount);
		
		// 4.分派到 /WEB-INF/coffee_result.jsp



		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/coffee_result.jsp");
		request.setAttribute("coffee", coffee); // 將 coffee 資料物件傳給 jsp
		rd.forward(request, response);
	}

}

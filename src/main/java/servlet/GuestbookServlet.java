package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Guestbook;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Servlet implementation class GuestbookServlet
 */
@WebServlet("/guestbook")
public class GuestbookServlet extends HttpServlet {
	
	private static final List<Guestbook> guestbooks = new CopyOnWriteArrayList<>();
	//CopyOnWriteArrayList:多執行緒安全，可以同時多人寫入

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestbookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/guestbook_form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message"); // 取得表單中的留言內容
		// 建立  guestbook 物件
		Guestbook guestbook = new Guestbook(message);
		// 加入到 guestbooks 集合中
		guestbooks.add(guestbook);
		// 重導到 /WEB-INF/guestbook_result.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/guestbook_result.jsp");
		request.setAttribute("message", message); // 本次留言
		request.setAttribute("guestbooks", guestbooks); // 歷史留言
		rd.forward(request, response);
	}

}

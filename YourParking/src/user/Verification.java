package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;

@WebServlet(urlPatterns={"/user/Verification"})
public class Verification {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// トークンを受け取る
		String token = request.getParameter("token");

		// トークンを分解してユーザーIDを取得
		String[] tokenParts = token.split("_");
		String user_idString = tokenParts[0];
		int user_id = Integer.parseInt(user_idString);

		UserDAO dao = new UserDAO();


		try {
			dao.change_flag(user_id);

			User user = new User();

			user = dao.take_all(user_id);

			HttpSession session = request.getSession();
        	session.setAttribute("user", user);

        	RequestDispatcher dispatcher = request.getRequestDispatcher("../car/add_car.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		    response.sendRedirect("/error/error.jsp");
		}
	}
}

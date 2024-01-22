package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/user/ChangePassOut"})
public class ChangePassOut {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// トークンを受け取る
		String token = request.getParameter("token");

		// トークンを分解してユーザーIDを取得
		String[] tokenParts = token.split("_");
		String user_idString = tokenParts[0];
		int user_id = Integer.parseInt(user_idString);

		try {

			HttpSession session = request.getSession();
        	session.setAttribute("user_id", user_id);

        	RequestDispatcher dispatcher = request.getRequestDispatcher("../user/change_pass_out.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		    response.sendRedirect("/error/error.jsp");
		}
	}
}

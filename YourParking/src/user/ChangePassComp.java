package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import bean.User;
import dao.UserDAO;

@WebServlet(urlPatterns={"/user/ChangePassComp"})
public class ChangePassComp extends HttpServlet implements Servlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user_id = (User) session.getAttribute("user_id");

		byte[] pass = request.getParameter("pass").getBytes();
        byte[] kakunin = request.getParameter("kakunin").getBytes();

    	String sha256 = DatatypeConverter.printHexBinary (pass). toLowerCase() ;
		String sha2562 = DatatypeConverter. printHexBinary (kakunin).toLowerCase();
		System.out.println (pass);
		System.out.println (kakunin);
		System.out.println (sha256);
		System.out.println (sha2562);

        if (!sha256.equals(sha2562)) {
            request.setAttribute("message", "パスワードと確認用パスワードが一致しません。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("../user/change_pass_out.jsp");
			dispatcher.forward(request, response);
        }

        try {
        	User user = new User();
            user.setUser_id(user_id.getUser_id());
            user.setPass(pass);

            UserDAO dao = new UserDAO();
            int result = dao.change_pass(user);


            if (result > 0) {
            	RequestDispatcher dispatcher = request.getRequestDispatcher("../user/change_pass_comp.jsp");
    			dispatcher.forward(request, response);
            } else {
                request.setAttribute("message", "ユーザーの登録に失敗しました。");
                RequestDispatcher dispatcher = request.getRequestDispatcher("../user/change_pass_out.jsp");
    			dispatcher.forward(request, response);
            }
        } catch (Exception e) {
	        e.printStackTrace();
	        request.getRequestDispatcher( "../error/error.jsp").forward(request,response );;
		}
	}
}

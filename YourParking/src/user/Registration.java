package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import bean.User;
import dao.UserDAO;

@WebServlet(urlPatterns={"/user/Registration"})
public class Registration extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
	        String name = request.getParameter("name");
	        String phone = request.getParameter("phone");
	        String mail = request.getParameter("mail");
	        String user_id = request.getParameter("user_id");
	        String credit = request.getParameter("credit");
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
				RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
				dispatcher.forward(request, response);
	        }

	        User user = new User();
	        user.setName(name);
	        user.setPhone(phone);
	        user.setMail(mail);
	        user.setUser_name(user_id);
	        user.setCredit(credit);
	        user.setPass(pass);

	        UserDAO dao = new UserDAO();
	        int result = dao.insert(user);


	        if (result > 0) {
	        	HttpSession session = request.getSession();
	        	session.setAttribute("user", user);

	            RequestDispatcher dispatcher = request.getRequestDispatcher("../user/EmailReg");
				dispatcher.forward(request, response);
	        } else {
	            request.setAttribute("message", "ユーザーの登録に失敗しました。");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
				dispatcher.forward(request, response);
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	request.getRequestDispatcher( "../error/error.jsp").forward(request,response );
	    }
    }
}

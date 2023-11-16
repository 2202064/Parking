package user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;
import tool.Action;

public class LoginAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String mail=request.getParameter("address");
		String pass=request.getParameter("pass");
		UserDAO dao=new UserDAO();
		User user=dao.search(mail, pass);

		if (user!=null) {
			session.setAttribute("user", user);
			return "../yourparking/top.jsp";
		}
		return "../error/login_error.jsp";
	}
}

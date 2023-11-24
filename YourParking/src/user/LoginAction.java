package user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import bean.User;
import dao.UserDAO;
import tool.Action;

public class LoginAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();
		String mail=request.getParameter("address");
		byte[] pass=request.getParameter("pass").getBytes();

		UserDAO dao=new UserDAO();
		try {


			User user=dao.search(mail);


			System.out.println (pass);
			System.out.println (user.getPass());


			String sha256 = DatatypeConverter.printHexBinary (pass). toLowerCase() ;
			String sha2562 = DatatypeConverter.printHexBinary (user.getPass()). toLowerCase() ;
			System.out.println(sha256);
			System.out.println(sha2562);

			if (user!=null) {
				if (sha256.equals(sha2562)){
					session.setAttribute("user", user);
				}
			}

		}catch (Exception e) {
			e. printStackTrace();
			return "../error/login_error.jsp";
		}
		return "../parking/top_user.jsp";
	}
}

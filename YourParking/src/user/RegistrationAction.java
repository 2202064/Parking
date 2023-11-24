package user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import bean.User;
import dao.UserDAO;
import tool.Action;

public class RegistrationAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
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
            return "registration.jsp";
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


            return "../car/add_car.jsp";
        } else {
            request.setAttribute("message", "ユーザーの登録に失敗しました。");
            return "registration.jsp";
        }
    }
}

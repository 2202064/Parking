package login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String pass = request.getParameter("pass");
        String kakunin = request.getParameter("kakunin");

        if (!pass.equals(kakunin)) {
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
            return "addcar.jsp";
        } else {
            request.setAttribute("message", "ユーザーの登録に失敗しました。");
            return "registration.jsp";
        }
    }
}

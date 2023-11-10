package login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;
import tool.Action;

public class FixAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("user_id");

            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String mail = request.getParameter("address");
            String user_id = request.getParameter("user_id");
            String credit = request.getParameter("credit");
            String pass = request.getParameter("pass");
            String kakunin = request.getParameter("pass_confirmation");

            if (!pass.equals(kakunin)) {
                return "fix.jsp";
            }

            User user = new User();
            user.setUser_id(userId);
            user.setName(name);
            user.setPhone(phone);
            user.setMail(mail);
            user.setUser_name(user_id);
            user.setCredit(credit);
            user.setPass(pass);

            UserDAO dao = new UserDAO();
            int result = dao.update(user);

            if (result > 0) {
                return "top_user.jsp";
            } else {
                return "fix.jsp";
            }
        }
    }

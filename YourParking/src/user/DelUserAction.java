package user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;
import tool.Action;

public class DelUserAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            int user_id = user.getUser_id();

            UserDAO dao = new UserDAO();
            int rowsDeleted = dao.delete(user_id);

            if (rowsDeleted > 0) {
                session.invalidate();
                return "del_user_out.jsp";
            }
        }
        return "../error/login_error.jsp";
    }
}

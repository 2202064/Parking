package car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;
import tool.Action;

public class DelCarAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            int userId = user.getUser_id();

            UserDAO dao = new UserDAO();
            int rowsDeleted = dao.delete(userId);

            if (rowsDeleted > 0) {
                session.invalidate();
                return "taikai_kakunin.jsp";
            }
        }
        return "login-error.jsp";
    }
}

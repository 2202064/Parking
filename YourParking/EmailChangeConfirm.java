package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;

@WebServlet("/customer/EmailChangeConfirm")
public class EmailChangeConfirm extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userIdString = request.getParameter("user_id");

        try {
            if (userIdString != null) {
                int userId = Integer.parseInt(userIdString);

                UserDAO userDAO = new UserDAO();

                User user = userDAO.getIdAndNewMail(userId);

                response.sendRedirect(request.getContextPath() + "/customer/emailChangeComplete.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/customer/error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/customer/error.jsp");
        }
    }
}

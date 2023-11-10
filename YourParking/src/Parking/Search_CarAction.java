package YourParking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Car;
import bean.User;
import dao.CarDAO;
import tool.Action;

public class Search_CarAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int user_Id = user.getUser_id();

        CarDAO dao = new CarDAO();
        List<Car> cars = dao.Search(user_Id);
        session.setAttribute("cars", cars);


            if (cars != null) {
                return "ownedcar_in.jsp";
            }
        return "login-error.jsp";
    }
}

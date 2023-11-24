package car;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Car;
import bean.User;
import dao.CarDAO;
import tool.Action;

public class SearchCarAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int user_id = user.getUser_id();

        CarDAO dao = new CarDAO();
        List<Car> cars = dao.search(user_id);
        session.setAttribute("cars", cars);


            if (cars != null) {
                return "upd_car.jsp";
            }
        return "../error/login_error.jsp";
    }
}

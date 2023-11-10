package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Car;
import dao.CarDAO;
import tool.Action;

public class AddcarAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Integer userId = (Integer) session.getAttribute("user_id");

            if (userId != null) {
                Car car = new Car();
                car.setCarName(request.getParameter("CAR_NAME"));
                car.setCarHigh(Double.parseDouble(request.getParameter("HIGH")));
                car.setCarWidth(Double.parseDouble(request.getParameter("WIDTH")));
                car.setCarLength(Double.parseDouble(request.getParameter("LENGTH")));
                car.setGroundHeight(Double.parseDouble(request.getParameter("GROUND_HEIGHT")));
                car.setCarWeight(Double.parseDouble(request.getParameter("WEIGHT")));
                car.setUser_Id(userId);

                int result = new CarDAO().insertCar(car);

                return (result > 0) ? "login.jsp" : "addcar.jsp";
            } else {
                return "login-error2.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error.jsp";
        }
    }
}

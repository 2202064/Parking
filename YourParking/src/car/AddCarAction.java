package car;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Car;
import bean.User;
import dao.CarDAO;
import tool.Action;

public class AddCarAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");


            if (user != null) {
            	Integer user_id = user.getUser_id();
                Car car = new Car();
                car.setCar_name(request.getParameter("CAR_NAME"));
                car.setCar_high(Double.parseDouble(request.getParameter("HIGH")));
                car.setCar_width(Double.parseDouble(request.getParameter("WIDTH")));
                car.setCar_length(Double.parseDouble(request.getParameter("LENGTH")));
                car.setGround_height(Double.parseDouble(request.getParameter("GROUND_HEIGHT")));
                car.setCar_weight(Double.parseDouble(request.getParameter("WEIGHT")));
                car.setUser_id(user_id);

                int result = new CarDAO().insert(car);
                session.setAttribute("car", car);

                if(result > 0){
                	request.setAttribute("suc_message", "追加しました");
                	return "add_car.jsp";
                }else{
                	request.setAttribute("fai_message", "失敗しました");
                	return "add_car.jsp";
                }
            } else {
                return "../error/session_error.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "../error/error.jsp";
        }
    }
}

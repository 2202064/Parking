package car;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Car;
import bean.User;
import dao.CarDAO;
import tool.Action;

public class UpdCarAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        try {

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");


            if (user != null) {
                Car car = new Car();

                car.setCar_id(Integer.parseInt(request.getParameter("car_id")));
                car.setCar_name(request.getParameter("car_name"));
                car.setCar_high(Double.parseDouble(request.getParameter("car_high")));
                car.setCar_width(Double.parseDouble(request.getParameter("car_width")));
                car.setCar_length(Double.parseDouble(request.getParameter("car_length")));
                car.setGround_height(Double.parseDouble(request.getParameter("ground_height")));
                car.setCar_weight(Double.parseDouble(request.getParameter("car_weight")));

                int result = new CarDAO().update(car);

                if(result > 0){
                	request.setAttribute("suc_message", "更新しました");
                    int user_id = user.getUser_id();

                    CarDAO dao = new CarDAO();
                    List<Car> cars = dao.search(user_id);
                    session.setAttribute("cars", cars);
                }else{
                	request.setAttribute("fai_message", "更新できませんでした");
                }
            	return "upd_car.jsp";
            } else {
                return "../error/login_error2.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "../error/error.jsp";
        }
    }
}

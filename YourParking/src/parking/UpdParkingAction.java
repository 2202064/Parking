package parking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Car;
import bean.Cd;
import bean.Parking;
import bean.User;
import dao.CarDAO;
import dao.ParkingDAO;
import tool.Action;

public class UpdParkingAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        try {

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");


            if (user != null) {
                Parking parking = new Parking();

                Cd cd = new Cd();
                cd.setCd_id(Integer.parseInt(request.getParameter("cd_id")));

                parking.setParking_name(request.getParameter("parking_name"));
                parking.setPrefectures(request.getParameter("car_name"));
                parking.setPark_length(Double.parseDouble(request.getParameter("car_high")));
                parking.setPark_high(Double.parseDouble(request.getParameter("car_width")));
                parking.setPark_width(Double.parseDouble(request.getParameter("car_length")));
                parking.setPark_weight(Double.parseDouble(request.getParameter("ground_height")));
                parking.setPark_space(request.getParameter("car_weight"));




                int result = new ParkingDAO().update(parking);

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

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

        	CarDAO dao = new CarDAO();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            String flag[] = request.getParameterValues("flag");


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
                if (flag != null) {
                	car.setFlag_use(1);

                	dao.change_0(user_id);
                	int result = dao.insertplus(car);
                    session.setAttribute("car", car);

                    int distinction = dao.distinction(user_id);

                    if (distinction == 1) {
                    	dao.only(user_id);
                    }

                    if(result > 0){
                    	request.setAttribute("suc_message", "追加しました");
                    	return "add_car.jsp";
                    }else{
                    	request.setAttribute("fai_message", "失敗しました");
                    	return "add_car.jsp";
                    }
                } else {
                	int result = dao.insert(car);
                    session.setAttribute("car", car);

                    int distinction = dao.distinction(user_id);

                    if (distinction == 1) {
                    	dao.only(user_id);
                    }

                    if(result > 0){
                    	request.setAttribute("suc_message", "追加しました");
                    	return "add_car.jsp";
                    }else{
                    	request.setAttribute("fai_message", "失敗しました");
                    	return "add_car.jsp";
                    }
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

package car;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Car;
import bean.User;
import dao.CarDAO;
import tool.Action;

public class DelCarAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
    	try{
	        HttpSession session = request.getSession();
	        User user = (User) session.getAttribute("user");


	        if (user != null) {
	            int car_id = Integer.parseInt(request.getParameter("car_id"));

	              int result = new CarDAO().delete(car_id);

	            if(result > 0){
	            	request.setAttribute("suc_message", "削除しました");
                    int user_id = user.getUser_id();
                    List<Car> cars = new CarDAO().search(user_id);
                    session.setAttribute("cars", cars);
	            }else{
	            	request.setAttribute("fai_message", "失敗しました");
	            }
	            return "upd_car.jsp";
	        }
	        return "session_error.jsp";

    	}catch (Exception e) {
            e.printStackTrace();
            return "../error/error.jsp";
        }
    }
}

package car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Car;
import bean.User;
import dao.CarDAO;

@WebServlet(urlPatterns={"/car/ChangeCar"})
public class ChangeCar extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            CarDAO dao = new CarDAO();
	        List<Car> car = new ArrayList<>();

            int user_id = user.getUser_id();
            Car car_use = dao.search_use(user_id);

            request.setAttribute("car_use",car_use );

            car = dao.search(user_id);

            request.setAttribute("car", car);
			RequestDispatcher dispatcher = request.getRequestDispatcher("change_car.jsp");
			dispatcher.forward(request, response);

        } catch (Exception e) {
	        e.printStackTrace();
	        request.getRequestDispatcher( "../error/error.jsp").forward(request,response );;
        }
    }
}

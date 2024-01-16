package car;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.CarDAO;

@WebServlet(urlPatterns={"/car/ChaCarAction"})
public class ChaCarAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
        	HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int car_id = Integer.parseInt(request.getParameter("car_id"));

            CarDAO dao = new CarDAO();

            Integer user_id = user.getUser_id();
            int change_0 = dao.change_0(user_id);

            request.setAttribute("change_0",change_0 );

            int change_use = dao.change_use(user_id, car_id);

            request.setAttribute("change_use", change_use);

            RequestDispatcher dispatcher = request.getRequestDispatcher("../car/ChangeCar");
			dispatcher.forward(request, response);
		} catch (Exception e) {
	        e.printStackTrace();
	        request.getRequestDispatcher( "../error/error.jsp").forward(request,response );;
        }
    }
}


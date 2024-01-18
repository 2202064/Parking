package parking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Parking;
import bean.Review;
import dao.ParkingDAO;
import dao.ReviewDAO;

@WebServlet(urlPatterns={"/parking/ParkingInfo"})
public class ParkingInfo extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int parking_id = Integer.parseInt(request.getParameter("parking_id"));
			ParkingDAO dao=new ParkingDAO();
			ReviewDAO Rdao=new ReviewDAO();
	        Parking parking = dao.searchSingle(parking_id);

			request.getSession().setAttribute("parking",parking );

			List<Review> search = new ArrayList<>();

			search = Rdao.search(parking_id);

			request.getSession().setAttribute("search", search);

		    RequestDispatcher dispatcher = request.getRequestDispatcher("parking.jsp");
		    dispatcher.forward(request, response);
		} catch (Exception e) {
	        e.printStackTrace();
	        request.getRequestDispatcher( "../error/error.jsp").forward(request,response );
		}
	 }
// doPostメソッドも同様に使用可能
}

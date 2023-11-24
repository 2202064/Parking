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
import dao.ParkingDAO;

@WebServlet("/parking/SearchCd")
public class SearchCd extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try{
	        // クエリパラメータ "prefectureId" の値を取得
	        Integer cd_id = Integer.parseInt(request.getParameter("cd_id"));

	        ParkingDAO dao=new ParkingDAO();
	        List<Parking> parking = new ArrayList<>();
	        parking =dao.search(cd_id);


	        request.getSession().setAttribute("parking",parking );
	        RequestDispatcher dispatcher = request.getRequestDispatcher("search_result2.jsp");
	        dispatcher.forward(request, response);
	    } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher( "../error/error.jsp").forward(request,response );;
        }
    }
    // doPostメソッドも同様に使用可能
}

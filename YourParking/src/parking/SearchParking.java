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

import bean.Cd;
import dao.CdDAO;

@WebServlet("/parking/SearchParking")
public class SearchParking extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try{
	        // クエリパラメータ "prefectureId" の値を取得
	        Integer prefectures_id = Integer.parseInt(request.getParameter("prefectures_id"));

	        CdDAO dao=new CdDAO();
	        List<Cd> prefectures = new ArrayList<>();
	        prefectures =dao.search(prefectures_id);


	        request.getSession().setAttribute("prefectures",prefectures );
	        RequestDispatcher dispatcher = request.getRequestDispatcher("search_result.jsp");
	        dispatcher.forward(request, response);
	    } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher( "../error/error.jsp").forward(request,response );;
        }
    }
    // doPostメソッドも同様に使用可能
}

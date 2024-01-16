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
import javax.servlet.http.HttpSession;

import bean.Cd;
import bean.Parking;
import bean.User;
import dao.CdDAO;
import dao.SampleDAO;

@WebServlet(urlPatterns={"/parking/SearchParking"})
public class SearchParking extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try{
	        // クエリパラメータ "prefectureId" の値を取得
	        Integer prefectures_id = Integer.parseInt(request.getParameter("prefectures_id"));
	        String consent = request.getParameter("consent");
	        String municipalities = request.getParameter("municipalities");

	        if(municipalities != null) {
	        	if(consent != null) {
		        	// 実寸地検索が押下されている場合
		        	HttpSession session = request.getSession();
		            User user = (User) session.getAttribute("user");
		            Integer user_id = user.getUser_id();

		        	SampleDAO dao=new SampleDAO();
		        	List<Parking> parking = new ArrayList<>();
		        	parking = dao.certainty(prefectures_id, user_id);

		        	request.getSession().setAttribute("parking",parking );
			        RequestDispatcher dispatcher = request.getRequestDispatcher("search_result.jsp");
			        dispatcher.forward(request, response);
		        } else {
		        	// 実寸地検索が押下されていない場合
		        	CdDAO dao=new CdDAO();
			        List<Cd> prefectures = new ArrayList<>();
			        prefectures = dao.search(prefectures_id);

			        request.getSession().setAttribute("prefectures",prefectures );
			        RequestDispatcher dispatcher = request.getRequestDispatcher("search_result.jsp");
			        dispatcher.forward(request, response);
		        }
	        } else{
	        	if(consent != null) {
		        	// 実寸地検索が押下されている場合
		        	HttpSession session = request.getSession();
		            User user = (User) session.getAttribute("user");
		            Integer user_id = user.getUser_id();

		        	SampleDAO dao=new SampleDAO();
		        	List<Parking> parking = new ArrayList<>();
		        	parking = dao.certainty(prefectures_id, user_id);

		        	request.getSession().setAttribute("parking",parking );
			        RequestDispatcher dispatcher = request.getRequestDispatcher("search_result.jsp");
			        dispatcher.forward(request, response);
		        } else {
		        	// 実寸地検索が押下されていない場合
		        	CdDAO dao=new CdDAO();
			        List<Cd> prefectures = new ArrayList<>();
			        prefectures = dao.search(prefectures_id);

			        request.getSession().setAttribute("prefectures",prefectures );
			        RequestDispatcher dispatcher = request.getRequestDispatcher("search_result.jsp");
			        dispatcher.forward(request, response);
		        }
	        }
	        
	    } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher( "../error/error.jsp").forward(request,response );;
        }
    }
    // doPostメソッドも同様に使用可能
}

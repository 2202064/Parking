package parking;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Car;
import bean.Review;
import bean.User;
import dao.CarDAO;
import dao.ReviewDAO;
import tool.Action;

public class ReviewAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        try {

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");


            if (user != null) {
                Review review = new Review();

                review.setParking_id(Integer.parseInt(request.getParameter("parking_id")));
                review.setUser_id(user.getUser_id());
                review.setDay(request.getParameter("day"));
                review.setGood(Integer.parseInt(request.getParameter("good")));
                review.setComment(request.getParameter("comment"));

                int result = new ReviewDAO().insert(review);

                if(result > 0){
                	request.setAttribute("suc_message", "更新しました");
                	List<Review> Allcome = new ArrayList<>();

                    ReviewDAO dao = new ReviewDAO();
                    List<Review> Allcomment = dao.search(Integer.parseInt(request.getParameter("parking_id"));
                    session.setAttribute("Allcomment", Allcomment);



                }else{
                	request.setAttribute("fai_message", "更新できませんでした");
                }
            	return "review_in.jsp";
            } else {
                return "../error/login_error2.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "../error/error.jsp";
        }
    }
}

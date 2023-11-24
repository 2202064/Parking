package user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;
import tool.Action;

public class UpdUserAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
    	try{
	        HttpSession session = request.getSession();
	        User user = (User) session.getAttribute("user");

	        String name = request.getParameter("name");
	        String phone = request.getParameter("phone");
	        String mail = request.getParameter("mail");
	        String user_name = request.getParameter("user_name");
	        String credit = request.getParameter("credit");
	        byte[] pass = request.getParameter("pass").getBytes();



	        user.setName(name);
	        user.setPhone(phone);
	        user.setMail(mail);
	        user.setUser_name(user_name);
	        user.setCredit(credit);
	        user.setPass(pass);

	        UserDAO dao = new UserDAO();
	        int result = dao.update(user);

	        if(result > 0){
	        	request.setAttribute("suc_message", "変更しました");
	        }else{
	        	request.setAttribute("fai_message", "失敗しました");
	        }
	    	return "upd_user.jsp";
    	}catch (Exception e) {
            e.printStackTrace();
            return "../error/error.jsp";
        }
    	}
}

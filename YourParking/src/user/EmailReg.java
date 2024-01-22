package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;
import utils.EmailUtility;

@WebServlet(urlPatterns={"/user/EmailReg"})
public class EmailReg {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		UserDAO dao = new UserDAO();

		User user = (User) session.getAttribute("user");
		String mail = user.getMail();

		try {
			User user_id = dao.searchId(mail);
			// トークンを生成する
			String token = user_id + "_" + System.currentTimeMillis();

			// メール認証用のリンクを生成
			String verificationLink = "http://" + request.getServerName() + ":" + request.getServerPort() +
		    contextPath + "/user/Verification?token=" + token;

		    // メール内容
		    String subject = "メールアドレスの確認";
		    String content = "以下のリンクをクリックして会員登録を完了してください。\n" + verificationLink;

		    // メール送信
		    EmailUtility.sendEmail(mail, subject, content);

		    // 変更リクエスト完了ページへリダイレクト
		    response.sendRedirect(contextPath + "/user/confirmation.jsp");
		} catch (Exception e) {
		    e.printStackTrace();
		    response.sendRedirect(contextPath + "/error/error.jsp");
		}
	}
}


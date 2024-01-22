package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;
import utils.EmailUtility;

@WebServlet(urlPatterns={"/user/ChangePassIn"})
public class ChangePassIn {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("mail");
        String contextPath = request.getContextPath();
		UserDAO dao = new UserDAO();

		try {
			int result = dao.verification("mail");

			if (result == 1) {
				try {
					User user_id = dao.searchId(mail);
					// トークンを生成する
					String token = user_id + "_" + System.currentTimeMillis();

					// メール認証用のリンクを生成
					String verificationLink = "http://" + request.getServerName() + ":" + request.getServerPort() +
				    contextPath + "/user/ChangePassOut?token=" + token;

				    // メール内容
				    String subject = "メールアドレスの確認";
				    String content = "以下のリンクをクリックしてパスワードを変更してください。\n" + verificationLink;

				    // メール送信
				    EmailUtility.sendEmail(mail, subject, content);

				    // 変更リクエスト完了ページへリダイレクト
				    response.sendRedirect(contextPath + "/user/change_pass_mail.jsp");
				} catch (Exception e) {
				    e.printStackTrace();
				    response.sendRedirect(contextPath + "/error/error.jsp");
				}
			} else {
				request.setAttribute("fai_message", "メールアドレスが登録されていません");
				RequestDispatcher dispatcher = request.getRequestDispatcher("change_pass_in.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
		    e.printStackTrace();
		    response.sendRedirect(contextPath + "/error/error.jsp");
		}
	}
}


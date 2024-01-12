package user;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.ProvisionalDAO;
import utils.EmailUtility;

@WebServlet("/customer/EmailChange")
public class EmailChange extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String newMail = request.getParameter("newMail");
        String contextPath = request.getContextPath();

        // セッションからUSER_IDを取得
        HttpSession session = request.getSession(false);
        int user_id = 0;

        if (session != null) {
            List<User> user_ids = (List<User>) session.getAttribute("user_ids");
            if (user_ids != null && !user_ids.isEmpty()) {
                // 現在のユーザーのUSER_IDを取得
                User currentUser = user_ids.get(user_ids.size() - 1); // 最後の要素を現在のユーザーと仮定
                user_id = currentUser.getUser_id();
            } else {
                response.sendRedirect("error.jsp");
                return;
            }
        } else {
            response.sendRedirect("error.jsp");
            return;
        }

        try {
            ProvisionalDAO provisionalDAO = new ProvisionalDAO();

            // UUIDを生成し、DBに一時データを登録
            UUID uuid = provisionalDAO.insertIdAndMail(user_id, newMail); // user_idを使用するよう修正

            // メール認証用のリンクを生成
            String verificationLink = "http://" + request.getServerName() + ":" + request.getServerPort() +
                    contextPath + "/customer/EmailChangeConfirm?uuid=" + uuid.toString();

            // メール内容
            String subject = "メールアドレス変更の確認";
            String content = "以下のリンクをクリックしてメールアドレスの変更を確認してください。\n" + verificationLink;

            // メール送信
            EmailUtility.sendEmail(newMail, subject, content);

            // 変更リクエスト完了ページへリダイレクト
            response.sendRedirect(contextPath + "/customer/emailChangeRequestComplete.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(contextPath + "/customer/emailChangeError.jsp");
        }
    }
}
package user;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProvisionalDAO;
import utils.EmailUtility;

@WebServlet("/user/ProvisionalSignup")
public class ProvisionalSignup extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // フォームからデータを取得
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");

        try {
            // DAOを使用してデータベースに仮登録
            String contextPath = request.getContextPath();
            ProvisionalDAO provisionalDAO = new ProvisionalDAO();

            // パスワードをハッシュ化
            String hashedPassword = hashPassword(password);

            UUID uuid = provisionalDAO.insertProv(mail, name, hashedPassword, tel);

            // 仮登録が成功した場合にはメールを送信
            if (uuid != null) {
                // メール認証用のリンクを生成
            	String verificationLink = "http://" + request.getServerName() + ":" + request.getServerPort() +
                        contextPath + "/user/Signup?uuid=" + uuid.toString();

                // メール内容
                String subject = "会員登録の確認";
                String content = "以下のリンクをクリックして会員登録を完了させてください。\n" + verificationLink;

                // メール送信
                EmailUtility.sendEmail(mail, subject, content);

                // 仮登録完了ページへリダイレクト
                response.sendRedirect(contextPath + "/YourParking/user/del_user_out.jsp");
            } else {
                // 仮登録失敗ページへリダイレクト
                response.sendRedirect(contextPath + "/YourParking/user/confirmation_out.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace(); // 本番環境では、適切なロギングに置き換えてください。
            response.sendRedirect("/YourParking/car/add_car.jsp"); // エラーページへリダイレクト
        }
    }

    // パスワードハッシュ化メソッド
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
        for (int i = 0; i < encodedhash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedhash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}



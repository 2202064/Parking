package test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

@WebServlet("/test/hash")
public class Hash extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws IOException {

		String password = request.getParameter ("user");
			try {
			MessageDigest md = MessageDigest.getInstance ("SHA-256") ;

			//Stringをハッシュ化
			byte[] digest = md.digest (password. getBytes (StandardCharsets.UTF_8)) ;
			byte[] digest2 = md.digest (password. getBytes (StandardCharsets.UTF_8));

			//ハッシュがそれぞれ違うことを確認
			System.out.println (digest);
			System.out.println (digest2);

			//ハッシュを比較するためにString化
			String sha256 = DatatypeConverter.printHexBinary (digest). toLowerCase() ;
			String sha2562 = DatatypeConverter. printHexBinary (digest2).toLowerCase();
			System.out.println(sha256);
			System.out.println(sha2562);
			}catch (Exception e) {
			e. printStackTrace();
			}
	}
}

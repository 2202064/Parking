package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;

public class MailDAO extends DAO {
	public User searchId(String mail) throws Exception {
		User user = new User();

		try (Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("SELECT FROM User WHERE MAIL = ?");){
	    	st.setString(1, mail); // プレースホルダに値を設定
		    ResultSet rs = st.executeQuery();
		    while (rs.next()) {
	            user.setUser_id(rs.getInt("USER_ID"));
	        }
	    }
		return user;
	}
}

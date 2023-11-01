package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;

public class UserDAO extends DAO{

	public User search(String mail, String pass)
		throws Exception{
		User user = null;

		Connection con = getConnection();

		PreparedStatement st;
		st=con.prepareStatement(
				"select * from customer where login = ? and password = ?");
		st.setString(1, mail);
		st.setString(2, pass);
		ResultSet rs=st.executeQuery();

		while (rs.next()){
			user = new User();
			user.setUser_Id(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setMail(rs.getString("mail"));
			user.setPhone(rs.getString("phone"));
			user.setPass(rs.getString("pass"));
			user.setUser_name(rs.getString("user_name"));
			user.setCredit(rs.getInt("credit"));

		}

		st.close();
		con.close();

		return user;
	}
	public int insert(User user) throws Exception{
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"insert into course values(null,?, ?, ?, ?, ?, ?)");
		st.setString(1, user.getName());
		st.setString(2, user.getMail());
		st.setString(3, user.getPhone());
		st.setString(4, user.getPass());
		st.setString(5, user.getUser_name());
		st.setInt(6, user.getCredit());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
}
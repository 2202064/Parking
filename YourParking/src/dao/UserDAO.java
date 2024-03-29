package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;

public class UserDAO extends DAO {


    public User search(String mail) throws Exception {
        User user = null;

        Connection con = getConnection();

        PreparedStatement st;
        st = con.prepareStatement("select * from user where mail = ?");
        st.setString(1, mail);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            user = new User();
            user.setUser_id(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setMail(rs.getString("mail"));
            user.setPhone(rs.getString("phone"));
            user.setPass(rs.getBytes("pass"));
            user.setUser_name(rs.getString("user_name"));
            user.setCredit(rs.getString("credit"));
            user.setFlag(rs.getInt("flag"));
        }

        st.close();
        con.close();

        return user;
    }

    public int delete(int user_id) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("UPDATE user SET flag = 2 WHERE user_id = ?");
        st.setInt(1, user_id);
        int line = st.executeUpdate();

        st.close();
        con.close();

        return line;
    }

    public int insert(User user) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("insert into user (user_id, name, mail, phone, pass, user_name, credit, flag) values(null, ?, ?, ?, ?, ?, ?, 0)");
        st.setString(1, user.getName());
        st.setString(2, user.getMail());
        st.setString(3, user.getPhone());
        st.setBytes(4, user.getPass());
        st.setString(5, user.getUser_name());
        st.setString(6, user.getCredit());
        int line = st.executeUpdate();

        st.close();
        con.close();

        return line;
    }

    public int update(User user) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("UPDATE user SET name = ?, mail = ?, phone = ?, user_name = ?, credit = ?, pass = ? WHERE user_id = ?");
        st.setString(1, user.getName());
        st.setString(2, user.getMail());
        st.setString(3, user.getPhone());
        st.setString(4, user.getUser_name());
        st.setString(5, user.getCredit());
        st.setBytes(6, user.getPass());
        st.setInt(7, user.getUser_id());

        int line = st.executeUpdate();

        st.close();
        con.close();

        return line;
    }

    public User searchId(String mail) throws Exception {
		User user = new User();

		try (Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM User WHERE MAIL = ?");){
	    	st.setString(1, mail); // プレースホルダに値を設定
		    try (ResultSet rs = st.executeQuery()) {
		    	while (rs.next()) {
		            user.setUser_id(rs.getInt("USER_ID"));
		        }
		    }
	    }
		return user;
	}

    public int change_flag(int user_id) throws Exception {

    	try (Connection con = getConnection();
    	PreparedStatement st = con.prepareStatement("UPDATE User SET flag = 1 WHERE user_id = ?");){
    		st.setInt(1, user_id);

    		int line = st.executeUpdate();

            st.close();
            con.close();

            return line;
    	}
    }

    public User take_all(int user_id) throws Exception {
    	User user = new User();

    	try (Connection con = getConnection();
    	PreparedStatement st = con.prepareStatement("SELECT * FROM User WHERE USER_ID = ?")) {
    		st.setInt(1, user_id);

    		try (ResultSet rs = st.executeQuery()) {
    			while (rs.next()) {
    				user.setUser_id(rs.getInt("USER_ID"));
    				user.setName(rs.getString("NAME"));
    				user.setUser_name(rs.getString("USER_NAME"));
    				user.setMail(rs.getString("MAIL"));
    				user.setPhone(rs.getString("PHONE"));
    				user.setCredit(rs.getString("CREDIT"));
    				user.setFlag(rs.getInt("FLAG"));
    			}
    		}
    	}
		return user;
    }

    public int verification(String mail) throws Exception {
    	int result;

    	try (Connection con = getConnection();
    	PreparedStatement st = con.prepareStatement("SELECT * FROM User WHERE MAIL = ?")) {
    		st.setString(1, mail);
    		try (ResultSet rs = st.executeQuery()) {
    			if (rs.next()) {
	    			result = 1;
	    		} else {
	    			result = 0;
	    		}
    		}
    	}

		return result;
    }
    public int change_pass(User user) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("UPDATE user SET pass = ? WHERE user_id = ?");
        st.setBytes(1, user.getPass());
        st.setInt(2, user.getUser_id());

        int line = st.executeUpdate();

        st.close();
        con.close();

        return line;
    }
	
	public boolean core(User user) {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("SELECT * FROM USER WHERE USER_NAME = ? OR PHONE = ? OR MAIL = ?")) {
            st.setString(1, user.getUser_name());
            st.setString(2, user.getPhone());
            st.setString(3, user.getMail());

            try (ResultSet rs = st.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			e1.printStackTrace();
		}
        return false;
    }
}

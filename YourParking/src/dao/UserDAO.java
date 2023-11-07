package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;

public class UserDAO extends DAO {

    public User search(String mail, String pass) throws Exception {
        User user = null;

        Connection con = getConnection();

        PreparedStatement st;
        st = con.prepareStatement("select * from user where mail = ? and pass = ?");
        st.setString(1, mail);
        st.setString(2, pass);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            user = new User();
            user.setUser_Id(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setMail(rs.getString("mail"));
            user.setPhone(rs.getString("phone"));
            user.setPass(rs.getString("pass"));
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

        PreparedStatement st = con.prepareStatement("insert into user values(null, ?, ?, ?, ?, ?, ?)");
        st.setString(1, user.getName());
        st.setString(2, user.getMail());
        st.setString(3, user.getPhone());
        st.setString(4, user.getPass());
        st.setString(5, user.getUser_name());
        st.setString(6, user.getCredit());
        st.setInt(7, user.getFlag());
        int line = st.executeUpdate();

        st.close();
        con.close();

        return line;
    }
}

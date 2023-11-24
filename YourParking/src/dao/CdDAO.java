package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Cd;

public class CdDAO extends DAO {

    public int insert(Cd cd) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("insert into cd (cd_id, cd_name) values(null, ?)");
        st.setString(1, cd.getCd_name());

        int line = st.executeUpdate();

        st.close();
        con.close();

        return line;
    }
	public List<Cd> search(int prefectures_id) throws Exception {
	    List<Cd> prefectures = new ArrayList<>();

	    try (Connection con = getConnection();
	         PreparedStatement st = con.prepareStatement("SELECT * FROM Cd WHERE PREFECTURES_ID = ?")) {
	        st.setInt(1, prefectures_id); // プレースホルダに値を設定

	        try (ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	                Cd cd = new Cd();
	                cd.setCd_name(rs.getString("CD_NAME"));
	                prefectures.add(cd);
	            }
	        }
	    }
	    return prefectures;
	    }
}

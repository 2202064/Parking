package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Review;

public class ReviewDAO extends DAO {

    public int insert(Review review) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("INSERT INTO REVIEW (REVIEW_ID, USER_ID, PARKING_ID, DAY, GOOD, COMMENT) VALUES (null, ?, ?, ?, ?, ?)")) {

        	st.setInt(1, review.getUser_id());
        	st.setInt(2, review.getParking_id());
        	st.setString(3, review.getDay());
        	st.setInt(4, review.getGood());
        	st.setString(5, review.getComment());



            return st.executeUpdate();
        }
    }

    public List<Review> search(int parking_id) throws Exception {
		List<Review> review = new ArrayList<>();

		try (Connection con1 = getConnection();
			PreparedStatement st1 = con1.prepareStatement("SELECT * FROM REVIEW WHERE PARKING_ID = ?")) {
			st1.setInt(1, parking_id); // プレースホルダに値を設定

	        try (ResultSet rs1 = st1.executeQuery()) {
	            while (rs1.next()) {
	                int user_id = rs1.getInt("user_id");

	                try (Connection con2 = getConnection();
	           	         PreparedStatement st2 = con2.prepareStatement("SELECT * FROM User WHERE USER_ID = ?")) {
	           	        st2.setInt(1, user_id); // プレースホルダに値を設定

	           	        try (ResultSet rs2 = st2.executeQuery()) {
	           	            while (rs2.next()) {
	           	            	Review rev = new Review();
	           	            	rev.setUser_name(rs2.getString("user_name"));
	           	            	rev.setComment(rs1.getString("comment"));
	           	            }
	           	        }
	                }
	            }
	        }
	    }
		return review;
	}


}
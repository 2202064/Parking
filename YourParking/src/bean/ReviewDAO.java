package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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


}

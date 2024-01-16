package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Car;
import bean.Parking;
import bean.Review;

public class ParkingDAO extends DAO {

	public List<Parking> search(String search) throws Exception {
	    List<Parking> parking = new ArrayList<>();

	    try (Connection con = getConnection();
	         PreparedStatement st = con.prepareStatement("SELECT * FROM PARKING WHERE MUNICIPALITIES = ?")) {
	        st.setString(1, search); // プレースホルダに値を設定

	        try (ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	                Parking park = new Parking();
	                park.setParking_id(rs.getInt("parking_id"));
	                park.setParking_name(rs.getString("parking_name"));
	                park.setPrefectures(rs.getString("prefectures"));
	                park.setMunicipalities(rs.getString("municipalities"));
	                park.setStreet(rs.getString("street"));
	                parking.add(park);
	            }
	        }
	    }
	    return parking;
	}

	public Parking searchSingle(int parking_id) throws Exception {
	    Parking parking = new Parking();

	    try (Connection con = getConnection();
	         PreparedStatement st = con.prepareStatement("SELECT * FROM PARKING WHERE PARKING_ID = ?")) {
	        st.setInt(1, parking_id); // プレースホルダに値を設定

	        try (ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	                parking.setParking_id(rs.getInt("parking_id"));
	                parking.setParking_name(rs.getString("parking_name"));
	                //parking.setScore(rs.getDouble("score"));
	                parking.setPrefectures(rs.getString("prefectures"));
	                parking.setMunicipalities(rs.getString("municipalities"));
	                parking.setStreet(rs.getString("street"));
	                parking.setPark_money(rs.getString("park_money"));
	                parking.setPark_payment(rs.getString("park_payment"));
	                parking.setPark_time(rs.getString("park_time"));
	                parking.setPark_space(rs.getString("park_space"));
	                parking.setPark_weight(rs.getDouble("park_weight"));
	                parking.setPark_high(rs.getDouble("park_high"));
	                parking.setPark_width(rs.getDouble("park_width"));
	                parking.setPark_length(rs.getDouble("park_length"));
	                parking.setActual_height(rs.getDouble("actual_height"));
	                parking.setActual_length(rs.getDouble("actual_length"));
	                parking.setActual_width(rs.getDouble("actual_width"));
	                parking.setXcoord(rs.getDouble("xcoord"));
	                parking.setYcoord(rs.getDouble("ycoord"));
	            }
	        }
	    }
	    return parking;
	}

	public List<Review> review(int parking_id) throws Exception {
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

    public int insertCar(Car car) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("INSERT INTO CAR (CAR_NAME, CAR_HIGH, CAR_WIDTH, CAR_LENGTH, CAR_WEIGHT, GROUND_HEIGHT) VALUES (?, ?, ?, ?, ?, ?)")) {

            st.setString(1, car.getCar_name());
            st.setDouble(2, car.getCar_high());
            st.setDouble(3, car.getCar_width());
            st.setDouble(4, car.getCar_length());
            st.setDouble(5, car.getCar_weight());
            st.setDouble(6, car.getGround_height());

            return st.executeUpdate();
        }
    }

    public List<Parking> certainty(String search, int user_id)throws Exception {
		List<Parking> parking = new ArrayList<>();

		try (Connection con1 = getConnection();
		PreparedStatement st1 = con1.prepareStatement("SELECT * FROM CAR WHERE USER_ID = ? AND FLAG = 1")) {
			st1.setInt(1, user_id);

			try (ResultSet rs1 = st1.executeQuery()) {
				while (rs1.next()) {
					double car_high = rs1.getDouble("car_high");
					double car_width = rs1.getDouble("car_width");
					double car_length = rs1.getDouble("car_length");
					double car_weight = rs1.getDouble("car_weight");

					try (Connection con2 = getConnection();
					PreparedStatement st2 = con2.prepareStatement("SELECT * FROM PARKING WHERE MUNICIPALITIES = ?")) {
						st2.setString(1, search);

						try (ResultSet rs2 = st2.executeQuery()) {
							while (rs2.next()) {
								int cd_id = rs2.getInt("CD_ID");

								try (Connection con3 = getConnection();
								PreparedStatement st3 = con3.prepareStatement("SELECT * FROM PARKING WHERE CD_ID = ?"
								+ "AND ACTUAL_HEIGHT >= ? AND ACTUAL_WIDTH >= ? AND ACTUAL_LENGTH >= ? AND ACTUAL_WEIGHT >= ?")) {
									st3.setInt(1, cd_id);
									st3.setDouble(2, car_high);
									st3.setDouble(3, car_width);
									st3.setDouble(4, car_length);
									st3.setDouble(5, car_weight);

									try (ResultSet rs3 = st3.executeQuery()) {
										while (rs3.next()) {
											Parking park = new Parking();
											park.setParking_id(rs3.getInt("parking_id"));
											park.setParking_name(rs3.getString("parking_name"));
											park.setPrefectures(rs3.getString("prefectures"));
											park.setMunicipalities(rs3.getString("municipalities"));
											park.setStreet(rs3.getString("street"));
											parking.add(park);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return parking;
	}
}

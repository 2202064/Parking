package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Car;
import bean.Parking;

public class ParkingDAO extends DAO {

	public List<Parking> search(int cd_id) throws Exception {
	    List<Parking> parking = new ArrayList<>();

	    try (Connection con = getConnection();
	         PreparedStatement st = con.prepareStatement("SELECT * FROM PARKING WHERE CD_ID = ?")) {
	        st.setInt(1, cd_id); // プレースホルダに値を設定

	        try (ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	                Parking park = new Parking();
	                park.setParking_id(rs.getInt("parking_id"));
	                park.setParking_name(rs.getString("parking_name"));
	                park.setPrefectures(rs.getString("prefuctures"));
	                park.setMunicipalities(rs.getString("municipalities"));
	                parking.add(park);
	            }
	        }
	    }

	    return parking;
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
	
 public int insert(Parking parking) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("INSERT INTO PARKING (parking_name, cd_id, prefectures, municipalities, street, park_high, park_width, park_length, park_weight, park_space, park_time, park_money, park_payment, park_genre, xcoord, ycoord) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            st.setString(1, parking.getParking_name());
            st.setInt(2, parking.getCd_id());
            st.setString(3, parking.getPrefectures());
            st.setString(4, parking.getMunicipalities());
            st.setString(5, parking.getStreet());
            st.setDouble(6, parking.getPark_high());
            st.setDouble(7, parking.getPark_width());
            st.setDouble(8, parking.getPark_length());
            st.setDouble(9, parking.getPark_weight());
            st.setString(10, parking.getPark_space());
            st.setString(11, parking.getPark_time());
            st.setString(12, parking.getPark_money());
            st.setString(13, parking.getPark_payment());
            st.setString(14, parking.getPark_genre());
            st.setDouble(15, parking.getXcoord());
            st.setDouble(16, parking.getYcoord());

            return st.executeUpdate();
        }
    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Car;

public class CarDAO extends DAO {

	public List<Car> search(int user_Id) throws Exception {
	    List<Car> cars = new ArrayList<>();

	    try (Connection con = getConnection();
	         PreparedStatement st = con.prepareStatement("SELECT * FROM CAR WHERE USER_ID = ?")) {
	        st.setInt(1, user_Id); // プレースホルダに値を設定

	        try (ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	                Car car = new Car();
	                car.setCar_id(rs.getInt("CAR_ID"));
	                car.setUser_id(rs.getInt("USER_ID"));
	                car.setCar_name(rs.getString("CAR_NAME"));
	                car.setCar_high(rs.getDouble("CAR_HIGH"));
	                car.setCar_width(rs.getDouble("CAR_WIDTH"));
	                car.setCar_length(rs.getDouble("CAR_LENGTH"));
	                car.setCar_weight(rs.getDouble("CAR_WEIGHT"));
	                car.setGround_height(rs.getDouble("GROUND_HEIGHT"));
	                cars.add(car);
	            }
	        }
	    }

	    return cars;
	}


    public int addCar(Car car) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("INSERT INTO CAR (CAR_ID, USER_ID, CAR_NAME, CAR_HIGH, CAR_WIDTH, CAR_LENGTH, CAR_WEIGHT, GROUND_HEIGHT) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)")) {

        	st.setInt(1, car.getUser_id());
            st.setString(2, car.getCar_name());
            st.setDouble(3, car.getCar_high());
            st.setDouble(4, car.getCar_width());
            st.setDouble(5, car.getCar_length());
            st.setDouble(6, car.getCar_weight());
            st.setDouble(7, car.getGround_height());

            return st.executeUpdate();
        }
    }

    public int updCar(Car car) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("UPDATE CAR SET CAR_NAME=?, CAR_HIGH=?, CAR_WIDTH=?, CAR_LENGTH=?, CAR_WEIGHT=?, GROUND_HEIGHT=? WHERE CAR_ID = ? " )) {

            st.setString(1, car.getCar_name());
            st.setDouble(2, car.getCar_high());
            st.setDouble(3, car.getCar_width());
            st.setDouble(4, car.getCar_length());
            st.setDouble(5, car.getCar_weight());
            st.setDouble(6, car.getGround_height());
            st.setInt(7, car.getCar_id());

            return st.executeUpdate();
        }
    }
}

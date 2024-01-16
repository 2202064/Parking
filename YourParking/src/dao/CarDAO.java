package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Car;

public class CarDAO extends DAO {

	// 保存車取得
	public List<Car> search(int user_id) throws Exception {
	    List<Car> cars = new ArrayList<>();

	    try (Connection con = getConnection();
	         PreparedStatement st = con.prepareStatement("SELECT * FROM CAR WHERE USER_ID = ? AND FLAG_USE = 0")) {
	        st.setInt(1, user_id); // プレースホルダに値を設定

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

	// 使用車情報取得
	public Car search_use(int user_id) throws Exception {
	    Car car_use = new Car();

	    try (Connection con = getConnection();
	         PreparedStatement st = con.prepareStatement("SELECT * FROM CAR WHERE USER_ID = ? AND FLAG_USE = 1")) {
	        st.setInt(1, user_id); // プレースホルダに値を設定

	        try (ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	            	car_use.setCar_id(rs.getInt("CAR_ID"));
	            	car_use.setUser_id(rs.getInt("USER_ID"));
	            	car_use.setCar_name(rs.getString("CAR_NAME"));
	            	car_use.setCar_high(rs.getDouble("CAR_HIGH"));
	            	car_use.setCar_width(rs.getDouble("CAR_WIDTH"));
	            	car_use.setCar_length(rs.getDouble("CAR_LENGTH"));
	            	car_use.setCar_weight(rs.getDouble("CAR_WEIGHT"));
	            	car_use.setGround_height(rs.getDouble("GROUND_HEIGHT"));
	            }
	        }
	    }

	    return car_use;
	}


    public int insert(Car car) throws Exception {
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

    public int insertplus(Car car) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("INSERT INTO CAR (CAR_ID, USER_ID, CAR_NAME, CAR_HIGH, CAR_WIDTH, CAR_LENGTH, CAR_WEIGHT, GROUND_HEIGHT, FLAG_USE) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)")) {

        	st.setInt(1, car.getUser_id());
            st.setString(2, car.getCar_name());
            st.setDouble(3, car.getCar_high());
            st.setDouble(4, car.getCar_width());
            st.setDouble(5, car.getCar_length());
            st.setDouble(6, car.getCar_weight());
            st.setDouble(7, car.getGround_height());
            st.setInt(8, car.getFlag_use());

            return st.executeUpdate();
        }
    }

    public int update(Car car) throws Exception {
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

    public int delete(int car_id) throws Exception {
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("DELETE FROM CAR WHERE CAR_ID = ?");
        st.setInt(1, car_id);
        int line = st.executeUpdate();

        st.close();
        con.close();

        return line;
    }
    // フラグを０にする
    public int change_0(int user_id) throws Exception {
    	Connection con = getConnection();

    	PreparedStatement st = con.prepareStatement("UPDATE CAR SET FLAG_USE=0 WHERE USER_ID = ?");
    	st.setInt(1, user_id);

    	return st.executeUpdate();
    }
    // フラグを1にする
    public int change_use(int user_id, int car_id) throws Exception {
    	Connection con = getConnection();

    	PreparedStatement st = con.prepareStatement("UPDATE CAR SET FLAG_USE = 1 WHERE USER_ID = ? AND CAR_ID = ?");
    	st.setInt(1, user_id);
    	st.setInt(2, car_id);

		return st.executeUpdate();
    }

    public int distinction(int user_id) throws Exception {

    	Connection con = getConnection();

    	PreparedStatement st = con.prepareStatement("SELECT COUNT(*) FROM CAR WHERE USER_ID = ?");
    	st.setInt(1, user_id);

    	ResultSet rs = st.executeQuery();
    	if (rs.next()) {
    		return rs.getInt(1);
    	} else {
    		return 0;
    	}
    }

    public int only(int user_id) throws Exception {
    	Connection con = getConnection();

    	PreparedStatement st = con.prepareStatement("UPDATE CAR SET FLAG_USE = 1 WHERE USER_ID = ?");
    	st.setInt(1, user_id);
		return st.executeUpdate();

    }

}

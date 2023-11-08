package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Car;

public class CarDAO extends DAO {

    public List<Car> getAllCars() throws Exception {
        List<Car> cars = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("SELECT * FROM CAR");
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Car car = new Car();
                car.setCarId(rs.getInt("CAR_ID"));
                car.setUserId(rs.getString("USER_ID"));
                car.setCarName(rs.getString("CAR_NAME"));
                car.setCarHigh(rs.getDouble("CAR_HIGH"));
                car.setCarWidth(rs.getDouble("CAR_WIDTH"));
                car.setCarLength(rs.getDouble("CAR_LENGTH"));
                car.setCarWeight(rs.getDouble("CAR_WEIGHT"));
                car.setGroundHeight(rs.getDouble("GROUND_HEIGHT"));
                cars.add(car);
            }
        }

        return cars;
    }

    public int insertCar(Car car) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("INSERT INTO CAR (CAR_NAME, CAR_HIGH, CAR_WIDTH, CAR_LENGTH, CAR_WEIGHT, GROUND_HEIGHT) VALUES (?, ?, ?, ?, ?, ?)")) {

            st.setString(1, car.getCarName());
            st.setDouble(2, car.getCarHigh());
            st.setDouble(3, car.getCarWidth());
            st.setDouble(4, car.getCarLength());
            st.setDouble(5, car.getCarWeight());
            st.setDouble(6, car.getGroundHeight());

            return st.executeUpdate();
        }
    }


}

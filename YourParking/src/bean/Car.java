package bean;

import java.io.Serializable;

public class Car implements Serializable {
    private int carId;
    private String userId;
    private String carName;
    private double carHigh;
    private double carWidth;
    private double carLength;
    private double carWeight;
    private double groundHeight;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
    public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public double getCarHigh() {
        return carHigh;
    }

    public void setCarHigh(double carHigh) {
        this.carHigh = carHigh;
    }

    public double getCarWidth() {
        return carWidth;
    }

    public void setCarWidth(double carWidth) {
        this.carWidth = carWidth;
    }

    public double getCarLength() {
        return carLength;
    }

    public void setCarLength(double carLength) {
        this.carLength = carLength;
    }

    public double getCarWeight() {
        return carWeight;
    }

    public void setCarWeight(double carWeight) {
        this.carWeight = carWeight;
    }

    public double getGroundHeight() {
        return groundHeight;
    }

    public void setGroundHeight(double groundHeight) {
        this.groundHeight = groundHeight;
    }
}

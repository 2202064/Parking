package bean;

import java.io.Serializable;

public class Car implements Serializable {
    private int car_id;
    private int user_id;
    private String car_name;
    private double car_high;
    private double car_width;
    private double car_length;
    private double car_weight;
    private double ground_height;
    private int flag_use;

	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_Id) {
		this.user_id = user_Id;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public double getCar_high() {
		return car_high;
	}
	public void setCar_high(double car_high) {
		this.car_high = car_high;
	}
	public double getCar_width() {
		return car_width;
	}
	public void setCar_width(double car_width) {
		this.car_width = car_width;
	}
	public double getCar_length() {
		return car_length;
	}
	public void setCar_length(double car_length) {
		this.car_length = car_length;
	}
	public double getCar_weight() {
		return car_weight;
	}
	public void setCar_weight(double car_weight) {
		this.car_weight = car_weight;
	}
	public double getGround_height() {
		return ground_height;
	}
	public void setGround_height(double ground_height) {
		this.ground_height = ground_height;
	}
	public int getFlag_use() {
		return flag_use;
	}
	public void setFlag_use(int flag_use) {
		this.flag_use = flag_use;
	}


}
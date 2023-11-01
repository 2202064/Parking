package bean;

import java.io.Serializable;

public class User implements Serializable {

	private int user_Id;
	private String name;
	private String mail;
	private String phone;
	private String pass;
	private String user_name;
	private int credit;


	public int getUser_Id() {
		return user_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}


}
package com.caps.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserTab")
public class User {

	 
    @Id
	
	private long phoneNo;
	
	private String name;
	
	private String email;
	
	private String gender;
	
	private String dob;
	
	private String securityQuestion;
	
	private String answer;
	
	private String password;
	

	
	private double marks;
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "User [phoneNo=" + phoneNo + ", name=" + name + ", email=" + email + ", gender=" + gender + ", dob="
				+ dob + ", securityQuestion=" + securityQuestion + ", answer=" + answer + ", password=" + password
				+ ", marks=" + marks + "]";
	}
	public User(long phoneNo, String name, String email, String gender, String dob, String securityQuestion,
			String answer, String password, double marks) {
		super();
		this.phoneNo = phoneNo;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
		this.password = password;
		this.marks = marks;
	}
	public User() {
		super();
	}
	
}

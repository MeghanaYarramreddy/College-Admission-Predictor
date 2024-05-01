package com.caps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "feedbackTable")
@SequenceGenerator(name="feedback_seq", initialValue=9876, allocationSize=50)
public class FeedBack {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="feedback_seq")
    private int feedbackId;
    private String userEmail;
    private String userName;
    private long phoneNo;
    private String feedback;
    private String description;
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
    
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FeedBack() {
	}
    
	
	public FeedBack(int feedbackId, String userEmail, String userName, long phoneNo, String feedback,
			String description) {
		super();
		this.feedbackId = feedbackId;
		this.userEmail = userEmail;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.feedback = feedback;
		this.description = description;
	}
	@Override
	public String toString() {
		return "FeedBack [feedbackId=" + feedbackId + ", userEmail=" + userEmail + ", userName=" + userName
				+ ", phoneNo=" + phoneNo + ", feedback=" + feedback + ", description=" + description + "]";
	}
    
}

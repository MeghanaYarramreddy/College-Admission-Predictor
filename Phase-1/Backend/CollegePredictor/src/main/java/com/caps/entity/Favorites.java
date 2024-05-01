package com.caps.entity;

import javax.persistence.*;
import java.util.HashMap;

@Table(name="Favorites")
@Entity
public class Favorites {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="favorite_seq")
    private String favoriteId;
    private Long userId;
    private String collegeCode;
    private String collegeName;
    private String state;
    private String city;
    private String address;
    private Long contactNumber;
    private HashMap<String, Double> branchCutoff;

    public Favorites() {    }

    public Favorites(String favoriteId, Long userId, String collegeCode, String collegeName, String state, String city, String address,
                   Long contactNumber, HashMap<String, Double> branchCutoff) {
        super();
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.collegeCode = collegeCode;
        this.collegeName = collegeName;
        this.state = state;
        this.city = city;
        this.address = address;
        this.contactNumber = contactNumber;
        this.branchCutoff = branchCutoff;
    }

    public String getFavoriteId() {
        return favoriteId;
    }
    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCollegeCode() {
        return collegeCode;
    }
    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    public String getCollegeName() {
        return collegeName;
    }
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public HashMap<String, Double> getBranchCutoff() {
        return branchCutoff;
    }
    public void setBranchCutoff(HashMap<String, Double> branchCutoff) {
        this.branchCutoff = branchCutoff;
    }

    @Override
    public String toString() {
        return "Favorites [favoriteId=" + favoriteId + ", userId=" + userId + ", " +
                "collegeCode=" + collegeCode + ", collegeName=" + collegeName + ", state=" + state
                + ", city=" + city + ", address=" + address + ", contactNumber=" + contactNumber + "," +
                " branchCutoff=" + branchCutoff + "]";
    }

}

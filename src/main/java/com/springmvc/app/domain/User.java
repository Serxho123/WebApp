package com.springmvc.app.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user", schema = "ordershop")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long userId;

    @Column(name = "name")
    private String userName;
    @Column(name = "phone")
    private String userPhone;
    @Column(name = "email")
    private String userEmail;
    @Column(name = "other")
    private String userOtherDetails;

    public User() {

    }

    public User(Long userId, String userName, String userPhone, String userEmail, String userOtherDetails) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userOtherDetails = userOtherDetails;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserOtherDetails() {
        return userOtherDetails;
    }

    public void setUserOtherDetails(String userOtherDetails) {
        this.userOtherDetails = userOtherDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userOtherDetails='" + userOtherDetails + '\'' +
                '}';
    }
}

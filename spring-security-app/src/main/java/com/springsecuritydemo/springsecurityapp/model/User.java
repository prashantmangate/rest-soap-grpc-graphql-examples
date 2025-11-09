package com.springsecuritydemo.springsecurityapp.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="users", schema = "cdp")
public class User {
    @Id
    @SequenceGenerator(name = "UserSequence", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSequence")
    @Column(name="id")
    private long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="mobile_no")
    private long mobile;
    @Column(name="date_of_birth")
    private Date dob;

    @Column(name = "enabled")
    private boolean enabled;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

//    public void setId(long id) {
    //    this.id = id;
  //  }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(name="username",unique = true)
    private String userName;

    @Column(name="password")
    private String password;

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

    public String setUserName(String userName) {
        return userName;
    }
    public String setPassword(String password) {
        return password;
    }

   @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", dob='" + dob + '\'' +
                ", enabled=" + enabled +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

//    public User(){}
    public User(String firstName, String lastName, String email, long mobile, Date dob, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
        this.userName = userName;
        this.password = password;
    }
}

package com.revature.Cthulazon.models;

import javax.print.DocFlavor;

public class User {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userName;
    private String password;
    private String role;
    private String userID;

    public User()
    {}


    public User(String userID, String userName, String password,String role,String firstName,String lastName,String emailAddress) {

        this.userID = userID;
        this.userName= userName;
        this.password=password;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role=role;
    }

    public User(String userID,String userName, String password, String emailAddress, String firstName, String lastName) {
        this.userID=userID;
        this.userName= userName;
        this.password=password;
        this.role="Default";
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;

    }


    //SETTERS//
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //GETTERS//

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUserName(){return userName;}

    public String getPassword(){return password;}

    public String getRole(){return role;}
    //Actions

    public String toFileString() {
        return userID + ":" + userName + ":" + password + ":" + role + ":"+ emailAddress + "\n";
    }
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}

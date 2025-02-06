package com.example.login;

import java.io.Serializable;

public class UserHelperClass implements Serializable {
    String email,pass,username,mobileNo;

    public UserHelperClass(String email, String username, String pass)//waprl nahi
    {
        this.email = email;
        this.username = username;
        this.pass = pass;
    }
    public UserHelperClass(String email, String username, String pass,String mobileNo)//he waprly
    {
        this.email = email;
        this.username = username;
        this.pass = pass;
        this.mobileNo = mobileNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }
    public String getPass() {
        return pass;
    }
    public String getUserName() {
        return username;
    }
}

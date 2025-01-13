package com.xu.pojo;

public class User {
    private String username;
    private String userpassword;
    private int locked;
    private int loginAttempts;

    public User(String username, String userpassword, int locked) {
        this.username = username;
        this.userpassword = userpassword;
        this.locked = locked;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }


    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }
}

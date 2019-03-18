package com.example.choco.tutorsignup;

public class Account {
    String username;
    String password;
    String type;
    String role;

    public Account() {

    }

    public Account (String username, String password, String type, String role) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.role = role;
    }

    public Account (String username, String password, String type) {

        this.username = username;
        this.password = password;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

}

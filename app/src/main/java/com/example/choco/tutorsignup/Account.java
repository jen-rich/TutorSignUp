package com.example.choco.tutorsignup;

public class Account {
    String name;
    String username;
    String password;
    String type;
    String role;

    public Account() {

    }

    public Account (String name, String username, String password, String type, String role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
        this.role = role;
    }

    public Account (String name, String username, String password, String type) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
    }

}

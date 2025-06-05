package com.example.register_page.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Register {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String confirmpassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }



    public Register(String id, String name, String email, String password, String confirmpassword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;

    }
    public Register() {
    }





}

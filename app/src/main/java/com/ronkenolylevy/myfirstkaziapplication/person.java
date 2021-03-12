package com.ronkenolylevy.myfirstkaziapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class person {
    private  String name,email,password,key;

    public person(String name, String email, String password, String key) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.key = key;
    }

    public person() {

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

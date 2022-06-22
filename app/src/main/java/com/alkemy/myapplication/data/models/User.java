package com.alkemy.myapplication.data.models;


//@Entity
//@Table(name = "user")

import com.google.firebase.firestore.PropertyName;

import java.io.Serializable;

public class User implements Serializable {

    @PropertyName("id")
    private String id="";


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    @PropertyName("name")
    private String name="";


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @PropertyName("user")
    private String user="";


    public String getUser() {
        return user;
    }


    public void setUser(String user) {
        this.user = user;
    }

    @PropertyName("token")
    private Long token= -1L;


    public Long getToken() {
        return token;
    }


    public void setToken(Long token) {
        this.token = token;
    }

    @PropertyName("cellphone")
    private Long cellphone=-1L;


    public Long getCellphone() {
        return cellphone;
    }


    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

}


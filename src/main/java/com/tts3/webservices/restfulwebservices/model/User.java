package com.tts3.webservices.restfulwebservices.model;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    private Integer id;

    @Size(min=2, message = "Name should have at least 2 characters")
    private String name;

    //validating the birthdate will always be in the past and not the future
    @Past
    private Date birthDate;

    private String post;

    public User(){}

    public User(Integer id, String name, Date birthDate, String post) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", post='" + post + '\'' +
                '}';
    }
}

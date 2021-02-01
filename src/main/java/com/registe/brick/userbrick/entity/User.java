package com.registe.brick.userbrick.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="sex")
    private int sex;//1男  0女

    @Column(name="age")
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}

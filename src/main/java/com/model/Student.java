/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author oswal metodos contructores, getters y setters del estudiante
 */
public class Student {

    //creamos las variables que corresponden a los atributos de estudiante en la BD
    private int idSt;
    private String name;
    private String gender;
    private String age;
    private String direction;
    private String email;
    private boolean active;

    //creamos los contructores que utilizaremso de Student, con los atributos necesarios
    public Student(int idSt, String name, String gender, String age, String direction, String email, boolean active) {
        this.idSt = idSt;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.direction = direction;
        this.email = email;

        this.active = active;
    }

    public Student(String name, String gender, String age, String direction, String email, boolean active) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.direction = direction;
        this.email = email;
        this.active = active;
    }

    //creamos los metodos getters que se utilizaran
    public int getIdSt() {
        return idSt;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getDirection() {
        return direction;
    }

    public String getEmail() {
        return email;
    }

    public boolean getActive() {
        return active;
    }

    public String getYesNoActive() {
        return (getActive() ? "Activo" : "Inactivo");
    }

    //creamos los metodos setters que se utilizaran
    public void setIdSt(int idSt) {
        this.idSt = idSt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}

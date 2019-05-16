/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author oswal metodos contructores, getters y setters del curso
 */
public class Course {
    //creamos todas las variables necesarioas para el modelo de curso

    private int idCou;
    private String name;
    private String description;
    private int hours;
    //creamos los contructores que vamos a utilizar con sus respectivos atributos

    public Course(int idCou, String name, String description, int hours) {
        this.idCou = idCou;
        this.name = name;
        this.description = description;
        this.hours = hours;
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, String description, int hours) {
        this.name = name;
        this.description = description;
        this.hours = hours;
    }

    //creamos los getters que seran utilizados
    public int getIdCou() {
        return idCou;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHours() {
        return hours;
    }

    //creamos los setters que vamos a utilizar
    public void setIdCou(int idCou) {
        this.idCou = idCou;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

}

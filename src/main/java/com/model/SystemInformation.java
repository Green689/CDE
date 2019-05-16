/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author oswal metodos contructores, getters y setters del sistema de
 * informacion
 */
public class SystemInformation {

    //cramos los atributos del objeto
    private int idSy;
    private String description;
    private int value;
    //creamos los contructores con sus respectivos atributos

    public SystemInformation(int idSy, String description, int value) {
        this.idSy = idSy;
        this.description = description;
        this.value = value;
    }

    public SystemInformation(int value) {
        this.value = value;
    }

    public SystemInformation(String description, int value) {
        this.description = description;
        this.value = value;
    }
    //creamos los metodos getters

    public int getIdSy() {
        return idSy;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }
    //creamos los metodos setters

    public void setIdSy(int idSy) {
        this.idSy = idSy;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

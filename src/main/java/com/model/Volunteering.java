/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author oswal metodos contructores, getters y setters del voluntariado
 */
public class Volunteering {

    //creamos las variables a utilizar en el modelo de voluntariado
    private int idVo;
    private String description;
    private int hoursEnd;
    private LocalDate date;
    private int idStu;

    //creamos los contructores con sus atributos a utilizar
    public Volunteering(int idVo, String description, int hoursEnd, int idStu) {
        this.idVo = idVo;
        this.description = description;
        this.hoursEnd = hoursEnd;
        this.idStu = idStu;
    }

    public Volunteering(int idVo, int hoursEnd, String description, Date date) {
        this.idVo = idVo;
        this.description = description;
        this.hoursEnd = hoursEnd;
        this.date = date.toLocalDate();
    }

    public Volunteering(int idVo, String description, int hoursEnd, LocalDate date, int idStu) {
        this.idVo = idVo;
        this.description = description;
        this.hoursEnd = hoursEnd;
        this.date = date;
        this.idStu = idStu;
    }

    public Volunteering(String description, int hoursEnd, Date date, int idStu) {
        this.description = description;
        this.hoursEnd = hoursEnd;
        this.date = date.toLocalDate();
        this.idStu = idStu;
    }

    public Volunteering(String description, int hoursEnd, int idStu) {
        this.description = description;
        this.hoursEnd = hoursEnd;
        this.idStu = idStu;
    }

    public Volunteering(String description, int hoursEnd) {
        this.description = description;
        this.hoursEnd = hoursEnd;
    }

    public Volunteering(int idVo, String description, int hoursEnd) {
        this.idVo = idVo;
        this.description = description;
        this.hoursEnd = hoursEnd;
    }

    //creamos los metodos getters
    public int getIdVo() {
        return idVo;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getHoursEnd() {
        return hoursEnd;
    }

    public int getIdStu() {
        return idStu;
    }

    //creamos los metodos setters
    public void setIdVo(int idVo) {
        this.idVo = idVo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date.toLocalDate();
    }

    public void setHoursEnd(int hoursEnd) {
        this.hoursEnd = hoursEnd;
    }

    public void setIdStu(int idStu) {
        this.idStu = idStu;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;
//hacemos los import que necesitaremos en el modelo de la asistencia

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author oswal metodos contructores, getters y setters de la asistencia
 */
public class Attendance {

    //creamos las variables a utilizar en el modelo de asistencia, con sus respectivos tipos de datos
    private int idAt;
    private int idStu;
    private int idCou;
    private LocalDate date;
    private String description;
    private boolean skipCourse;
    private int hours;
    private Course course;

    //creamos el contructor del objeto con los atributos que vamos a necesitar
    public Attendance(int idStu, int idCou, Date date, String description, boolean skipCourse, int hours) {
        this.idStu = idStu;
        this.idCou = idCou;
        this.date = date.toLocalDate();
        this.description = description;
        this.skipCourse = skipCourse;
        this.hours = hours;
    }

    public Attendance(int idAt, int idStu, int idCou, Date date, String description, boolean skipCourse, int hours, Course course) {
        this.idAt = idAt;
        this.idStu = idStu;
        this.idCou = idCou;
        this.date = date.toLocalDate();
        this.description = description;
        this.skipCourse = skipCourse;
        this.hours = hours;
        this.course = course;
    }

    public Attendance(int idAt, int idStu, int idCou, Date date, String description, boolean skipCourse, int hours) {
        this.idAt = idAt;
        this.idStu = idStu;
        this.idCou = idCou;
        this.date = date.toLocalDate();
        this.description = description;
        this.skipCourse = skipCourse;
        this.hours = hours;
    }

    public Attendance(int idAt, Date date, String description, boolean skipCourse, int hours) {
        this.idAt = idAt;
        this.date = date.toLocalDate();
        this.description = description;
        this.skipCourse = skipCourse;
        this.hours = hours;
    }

    public Attendance(String description, boolean skipCourse, int hours, int idAt, Date date) {
        this.description = description;
        this.skipCourse = skipCourse;
        this.hours = hours;
        this.idAt = idAt;
        this.date = date.toLocalDate();
    }

    public Attendance(int idAt, String description, boolean skipCourse, int hours) {
        this.idAt = idAt;
        this.description = description;
        this.skipCourse = skipCourse;
        this.hours = hours;
    }

    public Attendance(int idStu, int idCou, String description, boolean skipCourse, int hours) {
        this.idStu = idStu;
        this.idCou = idCou;
        this.description = description;
        this.skipCourse = skipCourse;
        this.hours = hours;
    }

    //generamos todos los metodos getters necesarios para el modelo
    public int getIdAt() {
        return idAt;
    }

    public int getIdStu() {
        return idStu;
    }

    public int getIdCou() {
        return idCou;
    }

    public LocalDate getDate() {
        return date;
    }

    public Course getCourse() {
        return course;
    }

    public String getDescription() {
        return description;
    }

    public boolean getSkipCourse() {
        return skipCourse;
    }

    public String getYesNoSkipCourse() {
        return (getSkipCourse() ? "Faltó" : "No Faltó");
    }

    public int getHours() {
        return hours;
    }
    //generamos todos los metodos setters necesarios para el modelo

    public void setIdAt(int idAt) {
        this.idAt = idAt;
    }

    public void setIdStu(int idStu) {
        this.idStu = idStu;
    }

    public void setIdCou(int idCou) {
        this.idCou = idCou;
    }

    public void setDate(Date date) {
        this.date = date.toLocalDate();
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSkipCourse(boolean skipCourse) {
        this.skipCourse = skipCourse;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

}

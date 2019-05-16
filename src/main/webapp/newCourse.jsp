<%-- 
    Document   : newCourse
    Created on : Mar 21, 2019, 9:03:43 PM
    Author     : oswal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CDE</title>
        <link rel="stylesheet" href="bulma.css">
    </head>
    <body>
        <nav class="navbar is-dark">
            <div class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item" href="StudentList">
                        Estudiantes
                    </a>
                    <a class="navbar-item" href="CourseList">
                        Cursos
                    </a>
                    <a class="navbar-item" href="SystemInformationList">
                        Horas de voluntariado
                    </a>
                </div>
            </div>
        </nav>
        <section class="section" style="width: 60%; margin-left: 300px">
            <span style="font-size: 30px ">Ingresar curso</span>
            <div class="container" style="margin-left: -300px; margin-top: -40px">
                <div class="buttons has-addons is-right">
                    <a class="button is-rounded is-warning" onClick="location.href = 'CourseList'">
                        Regresar
                    </a>
                </div>
            </div>
            <form action="NewCourse">
                <div class="field">
                    <label class="label">Nombre</label>
                    <div class="control">
                        <input required name="name" class="input" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Descripcion</label>
                    <div class="control">
                        <input name="description" class="input" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Horas</label>
                    <div class="control">
                        <input required name="hours" class="input" type="number" placeholder="Text input">
                    </div>
                </div>

                <div class="field is-grouped">
                    <div class="control">
                        <button class="button is-link">Submit</button>
                    </div>
                </div>
            </form>
    </body>
</html>

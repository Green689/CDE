<%-- 
    Document   : newVolunteering
    Created on : Mar 22, 2019, 8:50:20 PM
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
            <span style="font-size: 30px ">Ingresar Voluntariado</span>
            <div class="container" style="margin-left: -300px; margin-top: -40px">
                <div class="buttons has-addons is-right">
                    <a class="button is-rounded is-warning" onClick="location.href = 'StudentDetail?id=${stu.idSt}'">
                        Regresar
                    </a>
                </div>
            </div>
            <form action="VolunteeringNew">

                <div class="field">
                    <label class="label">Fecha</label>
                    <div class="control">
                        <input required name="date" class="input" type="date" placeholder="yyyy-mm-dd">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Descripcion</label>
                    <div class="control">
                        <input required name="description" class="input" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Horas realizadas</label>
                    <div class="control">
                        <input required name="hoursEnd" class="input" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field is-grouped">
                    <div class="control">
                        <button name="idSt" value="${stu.idSt}" class="button is-link">Submit</button>
                    </div>
                </div>
            </form>
        </section>
    </body>
</html>

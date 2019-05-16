<%-- 
    Document   : editAttendance
    Created on : Mar 22, 2019, 7:49:23 PM
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
            <span style="font-size: 30px ">Editar Asistencia</span>
            <div class="container" style="margin-left: -300px; margin-top: -40px">
                <div class="buttons has-addons is-right">
                    <a class="button is-rounded is-warning" onClick="location.href = 'StudentDetail?id=${stu.idSt}'">
                        Regresar
                    </a>
                </div>
            </div>
            <form action="AttendanceEdit">

                <div class="field">
                    <label class="label">Fecha</label>
                    <div class="control">
                        <input required name="date" value="${att.date}" class="input" type="date" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Descripcion</label>
                    <div class="control">
                        <input name="description" value="${att.description}" class="input" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Asistencia</label>
                    <div class="control">
                        <div class="select">
                            <select name="skipCourse">
                                <option value="true">Faltó</option>
                                <option value="false">No Faltó</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field">
                    <label class="label">Horas</label>
                    <div class="control">
                        <input required name="hours" value="${att.hours}" class="input" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field is-grouped">
                    <div class="control">
                        <button name="idAt" value="${att.idAt}" class="button is-link">Submit</button>
                    </div>
                </div>
            </form>
        </section>
    </body>
</html>

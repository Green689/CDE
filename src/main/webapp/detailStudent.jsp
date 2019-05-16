<%-- 
    Document   : detailStudent
    Created on : Mar 22, 2019, 10:00:12 AM
    Author     : oswal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <section class="section">
            <div class="container">
                <span style="font-size: 30px">Detalle de estudiante</span>
                <div class="container" style=" margin-top: -40px">
                    <div class="buttons has-addons is-right">
                        <a class="button is-rounded is-warning" onClick="location.href = 'StudentList'">
                            Regresar
                        </a>
                    </div>
                </div>
                <br>
                <table class="table is-fullwidth">
                    <tr>
                        <td>
                            <span>Nombre: </span>
                            ${stu.name}                                
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>Genero: </span>
                            ${stu.gender}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>Edad: </span>
                            ${stu.age}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>Estado: </span>
                            ${stu.yesNoActive}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>Direccion: </span>
                            ${stu.direction}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>Correo: </span>
                            ${stu.email}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="StudentShowEdit?id=${stu.idSt}">
                                Editar estudiante
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
        </section>
        <section class="section">
            <div class="container">
                <span style="font-size: 20px">Asistencia</span>
                <div class="container" style=" margin-top: -40px">
                    <div class="buttons has-addons is-right">
                        <a class="button is-rounded is-dark" onClick="location.href = 'AttendanceNewAllCourses?id=${stu.idSt}'">
                            Agregar asistencia
                        </a>
                    </div>
                </div>
                <br>
                <table class="table is-fullwidth">
                    <c:forEach items="${att}" var="att">
                        <tr>
                            <td>
                                <span>Curso: </span>
                                ${att.course.name}
                            </td>
                            <td>
                                <span>Descripcion: </span>
                                ${att.description}                                
                            </td>
                            <td>
                                <span>Horas: </span>
                                ${att.hours}
                            </td>
                            <td>
                                <span>Asistencia: </span>
                                ${att.yesNoSkipCourse}
                            </td>
                            <td>
                                <span>Fecha: </span>
                                ${att.date}
                            </td>
                            <td>
                                <a href="AttendanceShowEdit?id=${att.idAt}&ids=${stu.idSt}">
                                    Editar asistencia
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
        <section class="section">
            <div class="container">
                <span style="font-size: 20px">Voluntariado</span>
                <div class="container" style=" margin-top: -40px">
                    <div class="buttons has-addons is-right">
                        <a class="button is-rounded is-dark" onClick="location.href = 'VolunteeringEstudentId?id=${stu.idSt}'">
                            Agregar voluntariado
                        </a>
                    </div>
                </div>
                <br>
                <table class="table is-fullwidth">
                    <c:forEach items="${vol}" var="vol">
                        <tr>
                            <td>
                                <span>Descripcion: </span>
                                ${vol.description}
                            </td>
                            <td>
                                <span>Horas: </span>
                                ${vol.hoursEnd}                                
                            </td>
                            <td>
                                <span>Fecha: </span>
                                ${vol.date}
                            </td>
                            <td>
                                <a href="VolunteeringShowEdit?id=${vol.idVo}&ids=${stu.idSt}">
                                    Editar voluntariado
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <p style="color: #4366e5">Voluntariado restante: ${sys.value}</p>
            </div>
        </section>
    </body>
</html>

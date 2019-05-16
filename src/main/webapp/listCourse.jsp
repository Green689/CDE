<%-- 
    Document   : listCourse
    Created on : Mar 21, 2019, 8:56:13 PM
    Author     : oswal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--creamos nuestro jsp, y desplegamos la lista de cursos-->
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
                <span style="font-size: 30px">Lista de cursos</span>
                <div class="buttons has-addons is-right" style="margin-top: -40px">
                    <a class="button is-rounded is-dark" onClick="location.href = 'newCourse.jsp'">
                        Nuevo Curso
                    </a>
                </div>
                <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                    <c:forEach items="${courses}" var="cou">
                        <tr>
                            <td>                               
                                ${cou.name}                                
                            </td>
                            <td>
                                ${cou.description}
                            </td>
                            <td>
                                ${cou.hours}
                            </td>
                            <td>
                                <a href="CourseEdit?id=${cou.idCou}">
                                    Editar
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
    </body>
</html>

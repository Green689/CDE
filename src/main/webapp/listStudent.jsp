<%-- 
    Document   : index
    Created on : Mar 10, 2019, 2:47:01 PM
    Author     : oswal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--creamos nuestro jsp, y desplegamos la lista de estudiantes-->
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
                <span style="font-size: 30px">Lista de estudiantes</span>
                <div class="buttons has-addons is-right" style="margin-top: -40px">
                    <a class="button is-rounded is-dark" onClick="location.href = 'newStudent.jsp'">
                        Nuevo Estudiante
                    </a>
                </div>
                <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                    <c:forEach items="${students}" var="stu">
                        <tr>
                            <td>                               
                                ${stu.name}                                
                            </td>
                            <td>
                                ${stu.gender}
                            </td>
                            <td>
                                ${stu.age}
                            </td>
                            <td>
                                ${stu.yesNoActive}
                            </td>
                            <td>
                                <a href="StudentDetail?id=${stu.idSt}">
                                    Detalle
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
    </body>
</html>

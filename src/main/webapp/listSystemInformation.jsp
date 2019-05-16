<%-- 
    Document   : listSystemInformation
    Created on : Mar 21, 2019, 9:09:57 PM
    Author     : oswal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--creamos nuestro jsp, y desplegamos la lista de informacion del sistema-->
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
                <span style="font-size: 30px">Lista de informacion del sistema</span>
                <div class="buttons has-addons is-right" style="margin-top: -40px">
                    <a class="button is-rounded is-dark" onClick="location.href = 'newSystemInformation.jsp'">
                        Nuevo Ingreso
                    </a>
                </div>
                <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                    <c:forEach items="${systemInformation}" var="sys">
                        <tr>
                            <td>
                                ${sys.description}
                            </td>
                            <td>
                                ${sys.value}
                            </td>
                            <td>
                                <a href="SystemInformationShowEdit?id=${sys.idSy}">
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

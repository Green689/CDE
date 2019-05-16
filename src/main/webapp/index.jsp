<%-- 
    Document   : index
    Created on : Mar 24, 2019, 7:14:26 PM
    Author     : oswal
--%>

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

        <section class="hero is-primary is-medium">
            <div class="hero-body">
                <div class="container">
                    <h1 style="font-size: 50px" class="title">
                        Bienvenido
                    </h1>
                </div>
            </div>              
        </section>
    </body>
</html>

<%-- 
    Document   : editSystemInformation
    Created on : Mar 22, 2019, 9:15:14 PM
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
            <span style="font-size: 30px ">Editar Curso</span>
            <div class="container" style="margin-left: -300px; margin-top: -40px">
                <div class="buttons has-addons is-right">
                    <a class="button is-rounded is-warning" onClick="location.href = 'SystemInformationList'">
                        Regresar
                    </a>
                </div>
            </div>
            <form action="SystemInformationEdit">
                <div class="field">
                    <label class="label">Descripcion</label>
                    <div class="control">
                        <input required name="description" value="${sys.description}" class="input" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Valor</label>
                    <div class="control">
                        <input required name="value" value="${sys.value}" class="input" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field is-grouped">
                    <div class="control">
                        <button name="idSy" value="${sys.idSy}" class="button is-link">Submit</button>
                    </div>
                </div>
            </form>
        </section>
    </body>
</html>

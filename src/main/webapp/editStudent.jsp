<%-- 
    Document   : editStudent
    Created on : Mar 22, 2019, 5:14:37 PM
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
            <span style="font-size: 30px ">Editar estudiante</span>
            <div class="container" style="margin-left: -300px; margin-top: -40px">
                <div class="buttons has-addons is-right">
                    <a class="button is-rounded is-warning" onClick="location.href = 'StudentDetail?id=${stu.idSt}'">
                        Regresar
                    </a>
                </div>
            </div>
            <form action="StudentEdit">
                <div class="field">
                    <label class="label">Nombre</label>
                    <div class="control">
                        <input required name="name" value="${stu.name}" class="input" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Genero</label>
                    <div class="control">
                        <div class="select">
                            <select name="gender">
                                <option value="Masculino">Masculino</option>
                                <option value="Femenino">Femenino</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field">
                    <label class="label">Edad</label>
                    <div class="control">
                        <input required name="age" value="${stu.age}" class="input" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Direccion</label>
                    <div class="control">
                        <input required name="direction" value="${stu.direction}" class="input" type="text" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Email</label>
                    <div class="control">
                        <input required name="email" value="${stu.email}" class="input" type="email" placeholder="Text input">
                    </div>
                </div>

                <div class="field">
                    <label class="label">Estado</label>
                    <div class="control">
                        <div class="select">
                            <select name="active">
                                <option value="true">Activo</option>
                                <option value="false">Inactivo</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="field is-grouped">
                    <div class="control">
                        <button name="id" value="${stu.idSt}" class="button is-link">Submit</button>
                    </div>
                </div>
            </form>
        </section>
    </body>
</html>

<%-- 
    Document   : profesor
    Created on : Sep 21, 2016, 10:34:23 AM
    Author     : Adriana Gonzalez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Profesores</title>
    </head>
    <body>
        <form action="ProfesorController" method="post">
            <fileset>
                <legend>
                    Registro de profesores.
                </legend>
                <div>
                    <label for="idProfesor">Id Profesor: </label>
                    <input type="text" name="idProfesor" value="${profesor.idProfesor}" placeholder="Id de Profesor" readonly="readonly"/>
                </div>
                <div>
                    <label for="nombre">Nombre: </label>
                    <input type="text" name="nombre" value="${profesor.nombre}" placeholder="Nombre del Profesor"/>
                </div>
                <div>
                    <label for="experiencia">Experiencia: </label>
                    <input type="number" name="experiencia" value="${profesor.experiencia}" placeholder="Experiencia de Profesor"/>
                </div>
                <div>
                    <label for="carrera">Carrera: </label>
                    <input type="text" name="carrera" value="${profesor.carrera}" placeholder="Carrera de abscripcion"/>
                </div>
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fileset>
        </form>
    </body>
</html>

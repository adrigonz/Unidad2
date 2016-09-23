<%-- 
    Document   : index
    Created on : Sep 21, 2016, 11:33:35 AM
    Author     : adri_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <%-- <jsp:forward page = "/ProfesorController?action=listar" /> --%>
        <a href="ProfesorController?action=listar">Profesores</a>
        <a href="DoctoController?action=listar">Doctos</a>
    </body>
</html>

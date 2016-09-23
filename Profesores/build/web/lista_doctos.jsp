<%-- 
    Document   : lista_doctos
    Created on : Sep 23, 2016, 1:18:51 PM
    Author     : adri_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Doctos</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nota</th>
                    <th>Tramite titulacion</th>
                    <th>Activo</th>
                    <th>Descripcion</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${doctos}" var="docto">
                    <tr>
                        <td>${docto.idDocto}</td>
                        <td>${docto.notas}</td>
                        <td>${docto.tramiteTitulacion}</td>
                        <td>${docto.activo}</td>
                        <td>${docto.descripcion}</td>
                        <td>
                            <a href="DoctoController?action=cambiar&idDocto=${docto.idDocto}">Cambiar</a>
                        </td>
                        <td>
                            <a href="DoctoController?action=borrar&idDocto=${docto.idDocto}">Borrar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="DoctoController?action=agregar">Agregar Docto</a>
            
        </p>
    </body>
</html>

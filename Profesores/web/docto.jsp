<%-- 
    Document   : dosto
    Created on : Sep 23, 2016, 1:19:09 PM
    Author     : adri_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Doctos</title>
    </head>
    <body>
        <form action="DoctoController" method="post">
            <fileset>
                <legend>
                    Registro de Docto.
                </legend>
                <div>
                    <label for="idDocto">Id Docto: </label>
                    <input type="text" name="idDocto" value="${docto.idDocto}" placeholder="Id de Docto" readonly="readonly"/>
                </div>
                <div>
                    <label for="notas">Notas: </label>
                    <input type="text" name="notas" value="${docto.notas}" placeholder="Notas"/>
                </div>
                <div>
                    <label for="tramite_titulacion">Tramite Titulacion: </label>
                    <input type="number" name="tramite_titulacion" value="${docto.tramiteTitulacion}" placeholder="Tramite Ttulacion"/>
                </div>
                <div>
                    <label for="activo">Activo: </label>
                    <input type="text" name="activo" value="${docto.activo}" placeholder="Activo"/>
                </div>
                <div>
                    <label for="descripcion">Descripcion: </label>
                    <input type="text" name="descripcion" value="${docto.descripcion}" placeholder="Descripcion"/>
                </div>
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fileset>
        </form>
    </body>
</html>

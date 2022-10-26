<%-- 
    Document   : register
    Created on : 21-oct-2022, 10:43:13
    Author     : Barbara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo usuario</title>
    </head>
    <body>
    <h1>Nuevo usuario</h1>

    <form action="<%=request.getContextPath()%>/UserServlet" method="post">
        <table style="width:80%">
            <tr>
                <td>Correo electrónico</td>
                <td><input type="text" name="correo"/></td>
            </tr>
            <tr>
                <td>Nombre</td>
                <td><input type="text" name="nombre"/></td>
            </tr>
            <tr>
                <td>Apellido Paterno</td>
                <td><input type="text" name="apePaterno"/></td>
            </tr>
            <tr>
                <td>Apellido Materno</td>
                <td><input type="text" name="apeMaterno"/></td>
            </tr>
            <tr>
                <td>Dirección</td>
                <td><input type="text" name="direccion"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="pass"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Grabar"/></td>
            </tr>
        </table>
    </form>
    </body>
</html>

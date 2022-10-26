<%-- 
    Document   : success
    Created on : 21-oct-2022, 10:48:13
    Author     : Barbara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado de registro</title>
    </head>
    <body>
        <h1>Resultado de Registro</h1>
        <h3><%=request.getAttribute("message")%></h3>
    </body>
</html>

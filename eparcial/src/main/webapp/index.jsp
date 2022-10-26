<%-- 
    Document   : login
    Created on : 21-oct-2022, 10:37:28
    Author     : Barbara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>

        <h1>Ingresar</h1>

        <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
          <table style="width:50%">
            <tr>
              <td>Correo electrónico</td>
              <td><input type="text" name="correo"/></td>
            </tr>
            <tr>
              <td>Password</td>
              <td><input type="text" name="pass"/></td>
            </tr>
            <tr>
              <td><input type="submit" value="Ingresar"/></td>
            </tr>
          </table>
        </form>

        <br>
        <ul>
            <li><a href="<%=request.getContextPath()%>/UserServlet">Crear Usuario</a></li>
            <li><a href="<%=request.getContextPath()%>/PassServlet">Recuperar Contraseña</a></li>
        </ul>        
        
    </body>
</html>

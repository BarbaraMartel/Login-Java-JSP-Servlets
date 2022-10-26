<%-- 
    Document   : showpass
    Created on : 21-oct-2022, 18:28:11
    Author     : Barbara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Recuperar Contraseña</h1>

<form action="<%=request.getContextPath()%>/PassServlet" method="post">
  <table style="width:30%">
    <tr>
        <td><b>Buscar usuario</b></td>
    </tr>
    <tr>
      <td>Correo</td>
      <td><input type="text" name="correo" placeholder="Ingrese su correo"/></td>
      <td><input type="submit" value="Recuperar"/></td>
    </tr>

  </table>
</form>
  <br>
    <a href="<%=request.getContextPath()%>/LoginServlet">Regresar a Login</a>
    </body>
</html>

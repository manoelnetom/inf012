<%-- 
    Document   : consoantes
    Created on : 30/01/2018, 17:30:50
    Author     : ManoelNeto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conta Consoantes</title>
    </head>
    <body>
        <jsp:useBean id="frase" class="negocio.Frase" scope="page"/>
        <jsp:setProperty name="frase" property="*"/>
        <h1>O número de consoantes na frase é: <jsp:getProperty name="frase" property="consoantes"/></h1>
    </body>
</html>

<%-- 
    Document   : vogais
    Created on : 30/01/2018, 17:19:23
    Author     : ManoelNeto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conta Vogais</title>
    </head>
    <body>
        <jsp:useBean id="frase" class="negocio.Frase" scope="page"/>
        <jsp:setProperty name="frase" property="*"/>
        <h1>O número de vogais na frase é: <jsp:getProperty name="frase" property="vogais"/></h1>
    </body>
</html>

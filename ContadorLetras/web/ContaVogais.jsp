<%-- 
    Document   : ContaVogais
    Created on : 26/07/2017, 21:39:40
    Author     : ManoelNeto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="frase" class="modelo.Frase" scope="page"/>
        <jsp:setProperty name="frase" property="*"/>
        <h1>O número de vogais é: <jsp:getProperty name="frase" property="vogais"/></h1>
    </body>
</html>

<%-- 
    Document   : ContaConsoantes
    Created on : 26/07/2017, 21:40:38
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
        <h1>O número de consoantes é: <jsp:getProperty name="frase" property="consoantes"/></h1>
    </body>
</html>

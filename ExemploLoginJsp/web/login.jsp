<%-- 
    Document   : login
    Created on : 22/01/2018, 20:46:19
    Author     : ManoelNeto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TEste</title>
    </head>
    <body>
        <jsp:useBean id="variavel" class="modelo.Usuario" scope="page"/>
        <jsp:setProperty name="variavel" property="*"/>
        <h1><jsp:getProperty name="variavel" property="login"/></h1>
    </body>
</html>

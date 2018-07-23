<%-- 
    Document   : IMC
    Created on : 23/07/2018, 16:17:32
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="pessoa" class="negocio.Usuario" scope="page"/>
        <jsp:setProperty name="pessoa" property="*"/>
        <%
                String s="";
        
        %>
        <h1>
            <jsp:getProperty name="pessoa" property="imcTradicional"/>
        </h1>
    </body>
</html>

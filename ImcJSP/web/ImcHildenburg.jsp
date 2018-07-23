<%-- 
    Document   : ImcHildenburg
    Created on : 23/07/2018, 16:30:58
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
        
        <h1>
            <jsp:getProperty name="pessoa" property="imcHildenburg"/>
        </h1>
    </body>
</html>

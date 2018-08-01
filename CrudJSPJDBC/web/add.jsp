<%-- 
    Document   : add
    Created on : 30/07/2018, 16:24:36
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
        <jsp:useBean id="agenda" class="negocio.Agenda" scope="session"/>
        <jsp:setProperty name="agenda" property="*"/>
        <h1><% 
            out.println(agenda.addPessoa()); 
        %></h1>
       
         <a href="index.html">VOLTAR</a>
    </body>
</html>

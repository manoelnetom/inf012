<%-- 
    Document   : editar
    Created on : 01/08/2018, 16:49:13
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
        <%  agenda.setSelecetdPessoa(); %>
        
        <form action="ControleAgenda" method="POST">
            Cpf: <input type="text" name="cpf" value="<jsp:getProperty name="agenda" property="cpf"/>"/><br>  
            Nome: <input type="text" name="nome" value="<jsp:getProperty name="agenda" property="nome"/>"/><br>
            Telefone: <input type="text" name="telefone" value="<jsp:getProperty name="agenda" property="telefone"/>"/><br>
            <input type="submit" name="acao" value="Atualizar"/><br>
            <input type="submit" name="acao" value="Apagar"/><br>
        </form>
        <h1></h1>
    </body>
</html>

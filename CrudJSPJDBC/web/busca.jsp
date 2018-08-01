<%-- 
    Document   : busca
    Created on : 30/07/2018, 16:24:45
    Author     : aluno
--%>

<%@page import="model.Pessoa"%>
<%@page import="java.util.List"%>
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
        
        <table align="center" border="1">
             <% 
            List lista = agenda.getPessoas();
            for (int i = 0; i < lista.size(); i++) {
                Pessoa p=(Pessoa)lista.get(i);
             %>        
              
            <tr>
                <td><%=p.getCpf()%></td>
                <td><a href="ControleAgenda?acao='editar'&cpf='<%=p.getCpf()%>'"> <%=p.getNome()%></a></td>
  
            </tr>
            <%  }
             %>
        </table>
            
        
        <a href="index.html">VOLTAR</a>
    </body>
</html>

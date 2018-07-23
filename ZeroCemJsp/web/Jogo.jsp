<%-- 
    Document   : Jogo
    Created on : 23/07/2018, 16:44:36
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JogoZeroCem</title>
    </head>
    <body>
        <jsp:useBean id="jogo" class="negocio.Jogo" scope="session"/>
        <jsp:setProperty name="jogo" property="numeroDigitado"/>
        <h1>Voce digitou: <jsp:getProperty name="jogo" property="numeroDigitado"/></h1>
        <h1><jsp:getProperty name="jogo" property="resultado"/></h1>
        
         <form action="Jogo.jsp" method="POST">
            Numero: <input type="text" name="numeroDigitado"/><br>
            <input type="submit" name="bt" value="Jogar"/><br>
        </form>
    </body>
</html>

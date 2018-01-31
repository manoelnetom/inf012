<%-- 
    Document   : Jogo
    Created on : 31/01/2018, 19:29:56
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
        
        <jsp:useBean id="jogo" class="negocio.Forca" scope="session"/>
        <jsp:setProperty name="jogo" property="letra"/>
        <h1><jsp:getProperty name="jogo" property="categoria"/></h1>
        <form action="ForcaServlet" method="POST">
            <img src="<jsp:getProperty name="jogo" property="img"/>" width="308" height="310" alt="semnada"/><br>
            Letra:<input type="text" name="letra" />
            <input type="submit" value="Jogar" name="bt"/> 
             <input type="submit" value="Reiniciar" name="bt" /><br>
             <br>Letras já sorteadas: <jsp:getProperty name="jogo" property="letras"/><br>    
        </form>
        <h1><jsp:getProperty name="jogo" property="resultado"/></h1>
    </body>
</html>

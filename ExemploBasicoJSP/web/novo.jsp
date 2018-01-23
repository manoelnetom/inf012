<%-- 
    Document   : novo
    Created on : 17/01/2018, 21:27:05
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
        <%!
            int soma(String v){
           
            return 1+Integer.parseInt(v);
        }             %>
            
        <h1>A soma de 1 + <%=request.getParameter("valor")%> é = <%=soma(request.getParameter("valor"))%></h1>
            
        <br><h1><%=request.getParameter("valor")%></h1>    
    </body>
</html>

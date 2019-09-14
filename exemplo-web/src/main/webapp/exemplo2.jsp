<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exemplo 2 - JSP com código Java (scriptlet)</h1>
        <p><b style="color: red">NÃO USAR ESTE RECURSO NO PROJETO</b></p>
        <%
            Date dataAcesso = new Date();
            DateFormat formatter = 
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        %>
        <p>Data e hora de acesso: 
            <%= formatter.format(dataAcesso) %></p>
        <ul>
        <%
            for(int i = 1; i <= 100; i++) {
        %>
        <li>Item <%= i %></li>
        <%
          }  
        %>
        </ul>

    </body>
</html>

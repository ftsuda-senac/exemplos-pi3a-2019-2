<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exemplo 3 - JSP com JSTL + EL</h1>
        <%
            Date dataAcesso = new Date();
            request.setAttribute("dtAcesso", dataAcesso);
        %>
        <p>Data e hora de acesso: <fmt:formatDate value="${dtAcesso}" 
                        pattern="dd/MM/yyyy HH:mm:ss" /></p>
        <ul>
        <c:forEach begin="1" end="100" var="i">
            <li>Item <c:out value="${i}" /></li>
        </c:forEach>
        </ul>
    </body>
</html>

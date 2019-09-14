<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Dados preenchidos na query string</h1>
        <p>Nome: <c:out value="${nomeAttr}" /></p>
        <p>Idade: <c:out value="${idadeAttr}" /></p>
        <p>Info: <c:out value="${infoAttr}" /></p>
        <hr>
        <h2>Dados recuperados direto usando EL</h2>
        <p>Nome: <c:out value="${param.nome}" /></p>
        <p>Idade: <c:out value="${param.idade}" /></p>
        <p>Info: <c:out value="${param.info}" /></p>
        <p>Senha <c:out value="${param.senha}" /></p>
    </body>
</html>

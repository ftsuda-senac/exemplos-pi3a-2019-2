<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário</title>
    </head>
    <body>
        <h1>Formulário com fluxo normal do FORWARD direto</h1>
        <h2>Texto digitado: <c:out value="${textoDigitado}" /></h2>
        <p>Atualizar a página e ver o que acontece</p>
    </body>
</html>
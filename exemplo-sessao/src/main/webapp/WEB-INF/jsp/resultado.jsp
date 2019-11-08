<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário</title>
    </head>
    <body>
        <h1>Formulário com POST-REDIRECT-GET</h1>
        <h2>Texto digitado: <c:out value="${sessionScope.textoDigitado}" /></h2>
        <c:remove scope="session" var="textoDigitado" /> <%-- APAGAR O ATRIBUTO textoDigitado PARA SIMULAR ESCOPO FLASH --%>
        <p>Atualizar a página e ver o que acontece</p>
    </body>
</html>

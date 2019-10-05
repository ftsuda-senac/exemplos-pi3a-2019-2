<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulário - Resultado</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
    </head>
    <body>
        <h1>Dados salvos com sucesso</h1>
        <h2>Nome: <c:out value="${nomeAttr}" /></h2>
        <p>ID: <c:out value="${idAttr}" /></p>
        <p>Senha: <c:out value="${senhaAttr}" /></p>
        <p>Altura: <c:out value="${alturaAttr}" /></p>
        <p>Data de nascimento: <c:out value="${dtNascimentoAttr}" /> (idade: <c:out value="${idade}" />)</p>
        <p>Sexo: <c:out value="${sexoAttr}" /></p>
        <c:choose>
            <c:when test="${not empty interessesAttr}">
                <p>Interesses:</p>
                <ul>
                    <c:forEach items="${interessesAttr}" var="interesse">
                        <li><c:out value="${interesse}" /></li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <p>Nenhum interesse selecionado</p>
            </c:otherwise>
        </c:choose>
            
        <a href="${pageContext.request.contextPath}/formulario">Voltar</a>
    </body>
</html>

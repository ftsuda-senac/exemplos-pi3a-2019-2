<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Exemplo sessão</title>
        <style>
        	#itens {
        		display: grid;
        		grid-template-columns: 1fr 1fr 1fr
        	}
        	#itens > div {
        		border: 1px solid #fff;
        	}
        </style>
    </head>
    <body>
        <h1>Exemplo sessão</h1>
        <section id="itens">
       		<c:forEach items="${itens}" var="item">
        		<div style="border-color: ${item.corHex}">
	        		<h3><c:out value="${item.nome}" /></h3>
	        		<p>ID: <c:out value="${item.id}" /></p>
	        		<p>Valor: <c:out value="${item.valor}" /></p>
	        		<c:choose>
	        			<c:when test="${item.categorias != null && !item.categorias.isEmpty()}">
	        				<p>Categorias</p>
	        				<ul>
	        					<c:forEach items="${item.categorias}" var="cat">
	        						<li><c:out value="${cat.nome}" /></li>
	        					</c:forEach>
	        				</ul>
	        			</c:when>
	        			<c:otherwise>
	        				<p>Sem categorias</p>
	        			</c:otherwise>
	        		</c:choose>
	        		<div>
	        			<form method="post" action="${pageContext.request.contextPath}/exemplo-sessao">
	        				<input type="hidden" name="idItem" value="${item.id}" />
	        				<button type="submit" style="background-color: ${item.corHex}; color: #fff">Adicionar</button>
	        			</form>
	        		</div>
        		</div>
        	</c:forEach>
        </section>
        <hr />
        <section>
        	<c:choose>
        		<c:when test="${sessionScope.itensSelecionados != null && !sessionScope.itensSelecionados.isEmpty()}">
        			<h2>Itens selecionados</h2>
        			<table>
        				<thead>
        					<tr>
        						<th>#</th>
        						<th>ID Item</th>
        						<th>Nome item</th>
        						<th>Data e hora de inclusão</th>
        					</tr>
        				</thead>
        				<tbody>
        					<c:forEach items="${sessionScope.itensSelecionados}" var="itemSel" varStatus="stat">
        						<tr>
        							<td><c:out value="${stat.count}" /></td>
        							<td><c:out value="${itemSel.item.id}" /></td>
        							<td><c:out value="${itemSel.item.nome}" /></td>
        							<td><c:out value="${itemSel.dataHoraInclusao}" /></td>
        						</tr>
        					</c:forEach>
        				</tbody>
        			</table>
        		</c:when>
        		<c:otherwise>
        			<h2>Nenhum item selecionado</h2>
        		</c:otherwise>
        	</c:choose>
        </section>
    </body>
</html>

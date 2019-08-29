<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de produtos</title>
</head>
<body>
	<jsp:useBean id="dao" class="br.com.fj21.produto.dao.ProdutoDAO">
		<jsp:setProperty name="dao" property="session"/>	                             
	</jsp:useBean>
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Preço</th>			
			<th>Alterar</th>			
			<th>Remover</th>			
		</tr>
		
		<c:forEach var="produto" items="${dao.lista}">
			<tr>
			<td>${produto.id}</td>
			<td>${produto.nome}</td>
			<td>${produto.descricao}</td>
			<td>${produto.preco}</td>
			<td>
				<a href="mvc?logica=ChamarAlteracaoLogica&id=${produto.id}">Alterar</a>
			</td>
			<td>
				<a href="mvc?logica=RemoverProdutoLogica&id=${produto.id}">Remover</a>
			</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="adiciona-produto.jsp">Adicionar produto</a>
</body>
</html>
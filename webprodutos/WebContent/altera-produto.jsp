<html>
<head>
<title>Alterar produto</title>
</head>
<body>
	<form action="mvc" method="POST">
		ID: <input type="text" name="id" value="${produto.id}" readonly/><br/>
		Nome: <input type="text" name="nome" value="${produto.nome}"/><br/>
		Descri��o: <input type="text" name="descricao" value="${produto.descricao}"/><br/>
		Pre�o: <input type="text" name="preco" value="${produto.preco}"/><br/>
		<input type="hidden" name="logica" value="AdicionaAlteraProdutoLogica"/>
		<input type="submit" value="Gravar"/>
	</form>
</body>
</html>
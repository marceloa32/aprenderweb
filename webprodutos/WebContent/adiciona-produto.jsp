<html>
<head>
<title>Adicionar produto</title>
</head>
<body>
	<form action="mvc" method="POST">
		Nome: <input type="text" name="nome"/><br/>
		Descrição: <input type="text" name="descricao"/><br/>
		Preço: <input type="text" name="preco"/><br/>
		<input type="hidden" name="logica" value="AdicionaAlteraProdutoLogica"/>
		<input type="submit" value="Gravar"/>
	</form>
</body>
</html>
<html>
<head>
<title>Adicionar produto</title>
</head>
<body>
	<form action="mvc" method="POST">
		Nome: <input type="text" name="nome"/><br/>
		Descri��o: <input type="text" name="descricao"/><br/>
		Pre�o: <input type="text" name="preco"/><br/>
		<input type="hidden" name="logica" value="AdicionaAlteraProdutoLogica"/>
		<input type="submit" value="Gravar"/>
	</form>
</body>
</html>
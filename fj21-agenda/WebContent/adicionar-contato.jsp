<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FJ-21 Agenda: Adicionar contato</title>
<link type="text/css" href="css/jquery.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp"/>

	Dados do novo contato:<br/>
	
	<form action="mvc" method="POST">		
		Nome: <input type="text" name="nome"/><br/>
		Email: <input type="text" name="email"/><br/>
		Endereço: <input type="text" name="endereco"/><br/>
		Data de Nascimento: <caelum:campoData id="dataNascimento" valor=""/>
		<input type="hidden" name="logica" value="AdicionaContatoLogic"/>
		<input type="submit" value="Enviar"/>
	</form>
	
	<c:import url="rodape.jsp"/>
</body>
</html>
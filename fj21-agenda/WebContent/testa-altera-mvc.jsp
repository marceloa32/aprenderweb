<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FJ-21 Agenda: Alterar contato</title>
<link type="text/css" href="css/jquery.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp"/>

	Formulário para alteração de contatos:<br/>
	
	<form action="mvc" method="POST">
		Id:  <input type="text" name="id" value = "${contato.id}" readonly/><br/>
		Nome: <input type="text" name="nome" value = "${contato.nome}"/><br/>
		Email: <input type="text" name="email" value= "${contato.email}"/><br/>
		Endereço: <input type="text" name="endereco" value = "${contato.endereco}"/><br/>
		<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" var="data"/>
		Data de Nascimento: <caelum:campoData id="dataNascimento" valor="${data}"/> 
		<input type="hidden" name="logica" value="AlteraContatoLogic"/>
		<input type="submit" value="Enviar"/>
	</form>
	
	<c:import url="rodape.jsp"/>
</body>
</html>
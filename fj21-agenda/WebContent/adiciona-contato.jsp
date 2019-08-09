<!-- FJ-21 exr 5.9 -->
<!-- FJ-21 exr 8.4 -->
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

	<form action="adicionaContato">
		Nome: <input type="text" name="nome"/> <br/>
		E-mail: <input type="text" name="email"/> <br/>
		Endereço: <input type="text" name="endereco"/> <br/>
<!-- 		Data Nascimento: <input type="text" name="dataNascimento"/> <br/> -->
        Data Nascimento: <caelum:campoData id="dataNascimento"/> <br/>
		<input type="submit" value="Gravar"/>
	</form>
	
	<c:import url="rodape.jsp"/>
</body>
</html>
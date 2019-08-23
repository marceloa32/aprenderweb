<!-- 11.11 4 -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- 11.8 1 -->
<html>
<head>
<title>Adicionar tarefa</title>
</head>
<body>
	<h3>Adicionar tarefas</h3>
	<form:errors path="tarefa.descricao"/>
	<form action="adicionaTarefa" method="post">
		Descricao:<br/>
		<textarea name="descricao" rows=5 cols=100></textarea><br/>
		<input type="submit" value="Adicionar"/>
	</form>
</body>
</html>
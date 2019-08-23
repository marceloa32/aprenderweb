<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>Lista de tarefas</title>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="resources/js/jquery.js"></script>
</head>
<body>

	<script type="text/javascript">
		function finalizarAgora(id){
			$.post("finalizaTarefa",{'id':id}, function(){
				//funcao de callback positivo ()
				//selecionar o elemento html pelo id para alterar seu html
				$("#tarefa_"+id).html("Finalizado");
				now = new Date;
				$("#data_"+id).html(now.getDate() + "/" + (now.getMonth()+1).toString().padStart(2, "0") + "/" +now.getFullYear());
			})
		}
	</script>

	<a href="novaTarefa">Criar nova tarefa</a>
	<br/><br/>
	<table>
	<tr>
		<th>Id</th>
		<th>Descrição</th>
		<th>Finalizado?</th>
		<th>Data de finalização</th>
	</tr>
	<c:forEach items="${tarefas}" var="tarefa">
		<tr>
			<td>${tarefa.id}</td>
			<td>${tarefa.descricao}</td>
			<c:if test="${tarefa.finalizado eq false}">
				<!-- 11.20 3 -->
				<td id="tarefa_${tarefa.id}">
				 <a href="#" onClick="finalizarAgora(${tarefa.id})">Finalizar agora</a>
				</td>
			</c:if>
			<c:if test="${tarefa.finalizado eq true}">
				<td>Finalizado</td>
			</c:if>
			<td id="data_${tarefa.id}">
				<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />
			</td>
			<!-- 11.15 1 -->
			<td>
				<a href="removeTarefa?id=${tarefa.id}">Remover</a>
			</td>
			<!-- 11.15 2 -->
			<td>
			    <a href="mostraTarefa?id=${tarefa.id}">Alterar</a>
			</td>
		</tr>		
	</c:forEach>
	</table>
</body>
</html>
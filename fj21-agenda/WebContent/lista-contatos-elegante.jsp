<!-- FJ-21 exr 7.7 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- FJ-21 exr 7.15 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>
FJ-21: Lista de contatos elegante
</title>
</head>
<body>
	<!-- exr 7.13 -->	
	<c:import url="cabecalho.jsp"/>
	
	<!--  criar o DAO -->
	<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDAO"/>
	
	<table>
	<!--  exr 7.8 -->
	<tr>
		<th>Nome</th>
		<th>E-mail</th>
		<th>Endereço</th>
		<th>Data de nascimento</th>
		<th>Remover</th>		
	</tr>
	<!--  percorrer a lista de contatos -->
	<c:forEach var="contato" items="${dao.lista}">
		<tr bgcolor="#${contato.id %2 == 0 ? 'aaee88' : 'ffffff'}">
			<td>${contato.nome}</td>
			<td>
				<c:choose>
					<c:when test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:when>
					<c:otherwise>
						E-mail não cadastrado
					</c:otherwise>
				</c:choose>
			</td>			
			<td>
				${contato.endereco}
			</td>
			<td>
				<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
			</td>
			<td>
				<a href="mvc?logica=RemoverContatoLogic&id=${contato.id}">Remover</a>			     
			</td>
			<td>
				<a href="mvc?logica=ChamarAlteracaoLogic&id=${contato.id}">Alterar</a>			     
			</td>
		</tr>
	</c:forEach>	
	</table>

	<!-- exr 7.13 -->	
	<c:import url="rodape.jsp"/>
</body>
</html>

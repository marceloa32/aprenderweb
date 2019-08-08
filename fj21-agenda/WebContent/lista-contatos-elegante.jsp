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
	</tr>
	<!--  percorrer a lista de contatos -->
	<c:forEach var="contato" items="${dao.lista}">
		<tr bgcolor="#${contato.id %2 == 0 ? 'aaee88' : 'ffffff'}">
			<td>${contato.nome}</td>
			<!--  <td>${contato.email}</td>  -->
			<!-- exr 7.11 -->
<!-- 			<td> -->
<%-- 				<c:if test="${not empty contato.email}"> --%>
<%-- 				   <a href="mailto:${contato.email} }">${contato.email}</a> --%>
<%-- 				</c:if> --%>
<%-- 				<c:if test="${empty contato.email}"> --%>
<!-- 					E-mail não cadastrado -->
<%-- 				</c:if> --%>
<!-- 			</td> -->
			<!-- exr 7.11 opcional -->
			<td>
				<c:choose>
					<c:when test="${not empty contato.email}">
						<a href="mailto:${contato.email} }">${contato.email}</a>
					</c:when>
					<c:otherwise>
						E-mail não cadastrado
					</c:otherwise>
				</c:choose>
			</td>			
			<td>${contato.endereco}</td>
<%-- 			<td>${contato.dataNascimento.time}</td> --%>
			<td>
				<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
			</td>
		</tr>
	</c:forEach>	
	</table>

	<!-- exr 7.13 -->	
	<c:import url="rodape.jsp"/>
</body>
</html>

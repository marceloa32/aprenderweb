<!-- FJ-21 exr 7.7 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- FJ-21 exr 7.15 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- FJ-21 exr 8.16 -->
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>


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
	
	<display:table name="${dao.lista}" export="false" id="contato">
		<display:column property="id" title="ID"/>
		<display:column property="nome" title="Nome"/>
		<c:choose>
			<c:when test="${not empty contato.email}">
				<display:column property="email" title="Email"/>
			</c:when>
			<c:otherwise>
				<display:column value="E-mail nao cadastrado" title="Email"/>
			</c:otherwise>
		</c:choose>		
		<display:column property="endereco" title="Endereco"/>
		<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"  var="dataNasc"/>
		<display:column value="${dataNasc}" title="Data de Nascimento"/> -->
	</display:table>

	<!-- exr 7.13 -->	
	<c:import url="rodape.jsp"/>
</body>
</html>

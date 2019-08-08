<!-- FJ-21 6.4 -->
<%@ page import="java.util.*, br.com.caelum.agenda.dao.*, br.com.caelum.agenda.modelo.*, java.text.SimpleDateFormat" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
FJ-21: Lista de contatos com scriptlet
</title></head>
<body>
<table>
	<tr>
		<th>Nome</th>
		<th>E-mail</th>
		<th>Endereço</th>
		<th>Data de nascimento</th>
	</tr>
	<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	ContatoDAO dao = new ContatoDAO();
	List<Contato> contatos = dao.getLista();
	
	for(Contato contato : contatos){
	%>
	
	<tr>
		<td><%=contato.getNome() %></td>
		<td><%=contato.getEmail() %></td>
		<td><%=contato.getEndereco() %></td>
		<td><%=sdf.format(contato.getDataNascimento().getTime()) %></td>
	</tr>
		
	<%
	}
	%>
</table>
</body>
</html>
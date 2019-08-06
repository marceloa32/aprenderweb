<html>
<body>
 <%-- comentario em JSP aqui: nossa primeira pagina JSP --%>
 <%
 String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
 %>
 
 <% out.println(mensagem); %><br/>
 
 <%
 String desenvolvido = "Desenvolvido por MA / Caelum";
 %>
 <%= desenvolvido %><br/>
 <%
 System.out.println("Tudo foi executado!");
 %>
</body>
</html>
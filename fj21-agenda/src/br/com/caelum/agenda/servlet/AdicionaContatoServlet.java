package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaContatoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obter a saida
		PrintWriter out = response.getWriter();

		//obter os parametros do request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		
		//tratar a data
		Calendar dataNascimento = null;
		
		Date data;
		try {
			data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);			
		} catch (ParseException e) {			
			out.println("Erro de conversão da data");
			return;
		}
		
		//criar objeto contato para gravacao
		Contato c = new Contato();
		c.setNome(nome);
		c.setEmail(email);
		c.setEndereco(endereco);
		c.setDataNascimento(dataNascimento);

		
		//salvar o contato
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(c);
		
		//impressao dos dados gravados
		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + c.getNome() + " adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");
	}

}

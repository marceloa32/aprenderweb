package br.com.caelum.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class AlteraContatoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		Contato contato = new Contato();
		long id = Long.parseLong(req.getParameter("id"));
		contato.setId(id);
		contato.setNome(req.getParameter("nome"));
		contato.setEndereco(req.getParameter("endereco"));
		contato.setEmail(req.getParameter("email"));
		
		//converter a data de string para calendar
		String dataEmTexto = req.getParameter("dataNascimento");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		
		contato.setDataNascimento(dataNascimento);
		
		//-----
		ContatoDAO dao = new ContatoDAO();
		dao.altera(contato);
		
		//-----
		RequestDispatcher rd = req.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(req, resp);
		
		System.out.println("Alterando contato " + contato.getNome() +"...");
		
	}

}

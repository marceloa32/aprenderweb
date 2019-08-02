package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaFuncionario {

	public static void main(String[] args) {

		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario f1 = new Funcionario();
		f1.setNome("Josias Tobias");
		f1.setUsuario("j.tobias");
		f1.setSenha("mudar123");
	
		Funcionario f2 = new Funcionario();
		f2.setNome("Doroteia Lima");
		f2.setUsuario("d.lima");
		f2.setSenha("mudar456");
		
		Funcionario f3 = new Funcionario();
		f3.setNome("Horacio Lopes");
		f3.setUsuario("h.lopes");
		f3.setSenha("mudar789");
		
		dao.adiciona(f1);
		dao.adiciona(f2);
		dao.adiciona(f3);
		
		System.out.println("------");

		long maxId = 0;
		long minId = 0;
		for (Funcionario f : dao.getLista()) {
			System.out.println(f.getId());
			System.out.println(f.getNome());
			System.out.println(f.getUsuario());
			System.out.println(f.getSenha());
			if(f.getId() > maxId) {
				maxId = f.getId();
			}
			if(minId == 0 || f.getId() < minId) {
				minId = f.getId();
			}
		}

		//altera
		if(minId > 0) {
			Funcionario pesq = dao.pesquisar(minId);
			pesq.setUsuario("josias.tobias");
			dao.altera(pesq);
		}
				
		//remove
		
		if(maxId > 0) {
			dao.remove(dao.pesquisar(maxId));
		}
		
		System.out.println("------");
		for (Funcionario f : dao.getLista()) {
			System.out.println(f.getId());
			System.out.println(f.getNome());
			System.out.println(f.getUsuario());
			System.out.println(f.getSenha());			
		}


	}

}

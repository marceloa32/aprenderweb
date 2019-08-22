package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.TarefaDAO;
import br.com.caelum.tarefas.modelo.Tarefa;

//11.8 2
@Controller
public class TarefasController {

	//11.8 2
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}
	
	//11.8 3
	@RequestMapping("adicionaTarefa")
	public String adicionaTarefa(Tarefa tarefa) {
		TarefaDAO dao = new TarefaDAO();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}

}

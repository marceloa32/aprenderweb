package br.com.caelum.tarefas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	//11.11 3
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		
		if(result.hasFieldErrors()) {
			return "tarefa/formulario";
		}
		TarefaDAO dao = new TarefaDAO();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	//11.13 1
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		TarefaDAO dao = new TarefaDAO();
		model.addAttribute("tarefas", dao.getLista());
		return "tarefa/lista";
	}

}

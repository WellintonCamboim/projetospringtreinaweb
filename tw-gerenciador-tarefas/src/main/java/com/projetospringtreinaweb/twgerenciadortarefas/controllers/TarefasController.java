package com.projetospringtreinaweb.twgerenciadortarefas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projetospringtreinaweb.twgerenciadortarefas.model.Tarefa;
import com.projetospringtreinaweb.twgerenciadortarefas.repositories.RepositoryTarefa;

/**
 * @author WellintonCamboim-09-07-2019-Aula02-TreinoWeb
 *
 */
@Controller
@RequestMapping("/tarefas")
public class TarefasController {

	@Autowired
	private RepositoryTarefa repositoryTarefa;

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tarefas/listar");
		mv.addObject("tarefas", repositoryTarefa.findAll());
		return mv;
	}
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tarefas/inserir");
		mv.addObject("tarefa", new Tarefa());
		return mv;
	}
	
//	@PostMapping("/inserir")
//	public String inserir(Tarefa tarefa) {
//		repositoryTarefa.save(tarefa);
//		return "redirect:/tarefas/listar";
//	}

}

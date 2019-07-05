package com.projetospringtreinaweb.twgerenciadortarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author WellintonCamboim-05-07-2019-Aula01-TreinoWeb
 *
 */
//Controller --> Uma das funções de um Controller, é de entender as requesições que são feitas para minha Aplicação Java
@Controller //Anotação para atribuir que a presente Class é Controller
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/home");
		mv.addObject("mensagem", "Mensagem do controller");
		return mv;
	}

}

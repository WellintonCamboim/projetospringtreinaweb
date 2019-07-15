package com.projetospringtreinaweb.twgerenciadortarefas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projetospringtreinaweb.twgerenciadortarefas.model.Usuario;
import com.projetospringtreinaweb.twgerenciadortarefas.services.ServiceUsuario;

/**
 * @author WellintonCamboim-15-07-2019-Aula03-TreinoWeb
 *
 */
@Controller
public class ContaController {
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	@GetMapping("/login")
	public String login() {
		return "conta/login";
	}
	
	@GetMapping("/registration")
	public ModelAndView registrar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("conta/registrar");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	@PostMapping("/registration")
	public ModelAndView registrar(@Valid Usuario usuario, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		Usuario usr = serviceUsuario.encontrarPorEmail(usuario.getEmail());
		if (usr != null) {
			result.rejectValue("email", "", "Usuário já cadastrado");
		}
		if (result.hasErrors()) {
			mv.setViewName("conta/registrar");
			mv.addObject("usuario", usuario);
		}else{
			serviceUsuario.salvar(usuario);
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	

}

package com.projetospringtreinaweb.twgerenciadortarefas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetospringtreinaweb.twgerenciadortarefas.model.Usuario;
import com.projetospringtreinaweb.twgerenciadortarefas.repositories.RepositoryUsuario;

/**
 * @author WellintonCamboim-14-07-2019-Aula03-TreinoWeb
 *
 */
@Service
public class ServiceUsuario {
	
	@Autowired
	private RepositoryUsuario repositoryUsuario;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public Usuario encontrarPorEmail(String email) {
		return repositoryUsuario.findByEmail(email);
	}
	public void salvar(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		repositoryUsuario.save(usuario);
		
	}
}

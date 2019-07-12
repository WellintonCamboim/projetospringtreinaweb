package com.projetospringtreinaweb.twgerenciadortarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospringtreinaweb.twgerenciadortarefas.model.Usuario;

/**
 * @author WellintonCamboim-12-07-2019-Aula03-TreinoWeb
 *
 */
public interface RepositoryUsuario extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);

}

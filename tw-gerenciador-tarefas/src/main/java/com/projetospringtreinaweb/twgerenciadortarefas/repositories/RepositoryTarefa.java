package com.projetospringtreinaweb.twgerenciadortarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projetospringtreinaweb.twgerenciadortarefas.model.Tarefa;

/**
 * @author WellintonCamboim-09-07-2019-Aula02-TreinoWeb
 *
 */

public interface RepositoryTarefa extends JpaRepository<Tarefa, Long> {
	
	@Query("SELECT t FROM Tarefa t WHERE t.usuario.email = :emailUsuario")
	List<Tarefa> carregarTarefasPorUsuario(@Param("emailUsuario")String email);

}

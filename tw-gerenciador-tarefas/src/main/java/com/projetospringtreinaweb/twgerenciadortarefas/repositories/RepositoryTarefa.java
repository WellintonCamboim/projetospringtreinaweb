package com.projetospringtreinaweb.twgerenciadortarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospringtreinaweb.twgerenciadortarefas.model.Tarefa;

/**
 * @author WellintonCamboim-09-07-2019-Aula02-TreinoWeb
 *
 */

public interface RepositoryTarefa extends JpaRepository<Tarefa, Long> {

}

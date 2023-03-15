package br.com.restapi.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restapi.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	List<Topico> findAllByCursoNome(String nomeCurso);

}

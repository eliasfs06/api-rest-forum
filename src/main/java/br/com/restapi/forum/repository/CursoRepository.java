package br.com.restapi.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restapi.forum.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}

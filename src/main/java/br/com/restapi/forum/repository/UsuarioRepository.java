package br.com.restapi.forum.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restapi.forum.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);
}

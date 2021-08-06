package br.com.emersonmorgado.aluraflix.aluraflix.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.emersonmorgado.aluraflix.aluraflix.security.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
}

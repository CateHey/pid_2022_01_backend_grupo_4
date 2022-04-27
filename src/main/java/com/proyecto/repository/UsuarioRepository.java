package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.entidad.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {

	@Query("select u from Usuario u where u.email_usu = :p_usu and u.pass_usu = :p_pass")
	public List<Usuario> validarUsuario(@Param("p_usu") String usuario, 
					@Param("p_pass") String clave);
}

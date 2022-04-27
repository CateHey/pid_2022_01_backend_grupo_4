package com.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entidad.Usuario;
import com.proyecto.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

	@Override
	public List<Usuario> validarUsuario(String usuario, String clave) {
		return repository.validarUsuario(usuario, clave);
	}

}

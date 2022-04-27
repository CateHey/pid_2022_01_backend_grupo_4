package com.proyecto.service;

import com.proyecto.entidad.Usuario;

import java.util.List;

public interface UsuarioService {

    public abstract List<Usuario> validarUsuario(String usuario, String clave);

}

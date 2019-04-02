package ar.com.gestioncomercial.controller;

import ar.com.gestioncomercial.model.Usuario;

public interface UsuarioController extends CrudController<Usuario> {

    Usuario findByNombreAndPassword(String nombre, String password);
}

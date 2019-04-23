package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.UsuarioDAO;
import ar.com.gestioncomercial.controller.UsuarioController;
import ar.com.gestioncomercial.model.Usuario;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UsuarioControllerImpl implements UsuarioController {

    @EJB
    private UsuarioDAO usuarioDAO;

    @Override
    public void create(Usuario entity) {
        usuarioDAO.create(entity);
    }

    @Override
    public Usuario retrieve(Usuario entity) {
        return usuarioDAO.find(entity.getId());
    }

    @Override
    public Usuario retrievebyId(Long id) {
        return null;
    }

    @Override
    public void update(Usuario entity) {
        usuarioDAO.update(entity);
    }

    @Override
    public void delete(Usuario entity) {
        usuarioDAO.delete(entity);
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioDAO.getAllUsers();
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public Usuario findByNombreAndPassword(String nombre, String password) {
        return usuarioDAO.findByNombreAndPassword(nombre, password);
    }
}

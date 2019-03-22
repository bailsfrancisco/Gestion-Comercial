/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.Usuario;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author bailsfrancisco
 */
@Stateless
public class UsuarioDAO extends AbstractDAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario login(String email, String password) {
        Query query = em.createNamedQuery("user.findbyEmailAndPassword");
        query.setParameter("email", email);
        query.setParameter("password", password);
        Usuario usuario = null;
        try {
            usuario = (Usuario) query.getSingleResult();
        } catch (NoResultException nre) {

        }
        return usuario;
    }

}

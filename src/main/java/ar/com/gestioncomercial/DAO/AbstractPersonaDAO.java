/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Usuario;

import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Bails Francisco
 */
@Stateless
public class AbstractPersonaDAO extends AbstractDAO<AbstractPersona> {

    public AbstractPersonaDAO() {
        super(AbstractPersona.class);
    }

    public AbstractPersona findByName() {
        return null;
    }

    public List<AbstractPersona> getAllPersonas() {
        return getAll();
    }

    @Override
    protected List<AbstractPersona> getAll() {
        Query query = em.createNamedQuery("persona.getAll");
        return query.getResultList();
    }


    public AbstractPersona getByUsuario(Usuario usuario) {
        Query query = em.createNamedQuery("persona.getByUsuario");
        query.setParameter("usuario", usuario);
        try {
            return (AbstractPersona) query.getSingleResult();
        }catch (Exception e){
            return null;
        }

    }




}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.AbstractPersona;
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
}

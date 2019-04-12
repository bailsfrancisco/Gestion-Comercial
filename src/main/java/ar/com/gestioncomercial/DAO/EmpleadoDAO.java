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
public class EmpleadoDAO extends AbstractDAO<AbstractPersona> {

    public EmpleadoDAO() {
        super(AbstractPersona.class);
    }

    public List<AbstractPersona> getAllEmpleados() {
        return getAll();
    }

    @Override
    protected List<AbstractPersona> getAll() {
        Query query = em.createNamedQuery("empleado.getAll");
        return query.getResultList();
    }

}

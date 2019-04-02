/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Reparacion;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Bails Francisco
 */
@Stateless
public class ReparacionDAO extends AbstractDAO<Reparacion> {

    public ReparacionDAO() {
        super(Reparacion.class);
    }

    @Override
    protected List<Reparacion> getAll() {

        Query query = em.createNamedQuery("reparacion.getAllReparaciones");
        return query.getResultList();
    }

    public List<Reparacion> getAllReparaciones(){
        return getAll();
    }


}

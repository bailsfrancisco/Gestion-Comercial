/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Proveedor;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Bails Francisco
 */
@Stateless
public class ProveedorDAO extends AbstractDAO<AbstractPersona> {

    public ProveedorDAO() {
        super(AbstractPersona.class);
    }

    public List<AbstractPersona> getAllProveedores() {
        return getAll();
    }

    @Override
    protected List<AbstractPersona> getAll() {
        Query query = em.createNamedQuery("proveedor.getAllProveedores");
        return query.getResultList();
    }
}

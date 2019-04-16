/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.Factura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author bailsfrancisco
 */
@Stateless
public class FacturaDAO extends AbstractDAO<Factura> {

    public FacturaDAO() {
        super(Factura.class);
    }

    public List<Factura> getAllFacturas() {
        return getAll();
    }

    @Override
    protected List<Factura> getAll() {
        Query query = em.createNamedQuery("factura.getAll");
        return query.getResultList();
    }
}

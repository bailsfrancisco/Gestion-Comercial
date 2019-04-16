/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.DetalleFactura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author bailsfrancisco
 */
@Stateless
public class DetalleFacturaDAO extends AbstractDAO<DetalleFactura> {

    public DetalleFacturaDAO() {
        super(DetalleFactura.class);
    }

    public List<DetalleFactura> getAllDetalleFacturas() {
        return getAll();
    }

    @Override
    protected List<DetalleFactura> getAll() {
        Query query = em.createNamedQuery("detalle_factura.getAll");
        return query.getResultList();
    }
}

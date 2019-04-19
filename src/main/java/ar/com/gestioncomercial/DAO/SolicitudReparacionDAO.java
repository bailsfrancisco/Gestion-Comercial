/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.SolicitudReparacion;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Bails Francisco
 */
@Stateless
public class SolicitudReparacionDAO extends AbstractDAO<SolicitudReparacion> {

    public SolicitudReparacionDAO() {
        super(SolicitudReparacion.class);
    }

    @Override
    protected List<SolicitudReparacion> getAll() {
        Query query = em.createNamedQuery("solicitudReparacion.getAllSolicitudes");
        return query.getResultList();
    }

    public List<SolicitudReparacion> getSolicitudesReparacion() {
        return getAll();
    }

    public List<SolicitudReparacion> getSolicitudCliente() {
        Query query = em.createNamedQuery("solicitudReparacion.getSolicitudPorCliente");
        return query.getResultList();
    }

}

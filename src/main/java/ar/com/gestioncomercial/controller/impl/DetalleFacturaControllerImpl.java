/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.DetalleFacturaDAO;
import ar.com.gestioncomercial.controller.DetalleFacturaController;
import ar.com.gestioncomercial.model.DetalleFactura;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author bailsfrancisco
 */
@Stateless
public class DetalleFacturaControllerImpl implements DetalleFacturaController {

    @EJB
    private DetalleFacturaDAO detallefacturaDAO;

    @Override
    public void create(DetalleFactura entity) {
        detallefacturaDAO.create(entity);
    }

    @Override
    public DetalleFactura retrieve(DetalleFactura entity) {
        return null;
    }

    @Override
    public DetalleFactura retrievebyId(Long id) {
        return detallefacturaDAO.find(id);
    }

    @Override
    public void update(DetalleFactura entity) {
        detallefacturaDAO.update(entity);
    }

    @Override
    public void delete(DetalleFactura entity) {
        detallefacturaDAO.update(entity);
    }

    @Override
    public List<DetalleFactura> getAll() {
        return detallefacturaDAO.getAllDetalleFacturas();
    }

    public DetalleFacturaDAO getDetalleFacturaDAO() {
        return detallefacturaDAO;
    }

    public void setDetalleFacturaDAO(DetalleFacturaDAO detallefacturaDAO) {
        this.detallefacturaDAO = detallefacturaDAO;
    }

}

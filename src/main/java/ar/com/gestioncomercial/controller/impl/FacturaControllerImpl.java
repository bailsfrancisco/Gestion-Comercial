/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.FacturaDAO;
import ar.com.gestioncomercial.controller.FacturaController;
import ar.com.gestioncomercial.model.Factura;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author bailsfrancisco
 */
@Stateless
public class FacturaControllerImpl implements FacturaController {

    @EJB
    private FacturaDAO facturaDAO;

    @Override
    public void create(Factura entity) {
        facturaDAO.create(entity);
    }

    @Override
    public Factura retrieve(Factura entity) {
        return null;
    }

    @Override
    public Factura retrievebyId(Long id) {
        return facturaDAO.find(id);
    }

    @Override
    public void update(Factura entity) {
        facturaDAO.update(entity);
    }

    @Override
    public void delete(Factura entity) {
        facturaDAO.delete(entity);
    }

    @Override
    public List<Factura> getAll() {
        return facturaDAO.getAllFacturas();
    }

    public FacturaDAO getFacturaDAO() {
        return facturaDAO;
    }

    public void setFacturaDAO(FacturaDAO facturaDAO) {
        this.facturaDAO = facturaDAO;
    }

}

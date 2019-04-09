package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.CotizacionDAO;
import ar.com.gestioncomercial.controller.CotizacionController;
import ar.com.gestioncomercial.model.Cotizacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CotizacionControllerImpl implements CotizacionController {

    @EJB
    private CotizacionDAO cotizacionDAO;


    @Override
    public void create(Cotizacion entity) {
        cotizacionDAO.create(entity);
    }

    @Override
    public Cotizacion retrieve(Cotizacion entity) {
        return null;
    }

    @Override
    public Cotizacion retrievebyId(Long id) {
        return null;
    }

    @Override
    public void update(Cotizacion entity) {
        cotizacionDAO.update(entity);
    }

    @Override
    public void delete(Cotizacion entity) {
        cotizacionDAO.delete(entity);
    }

    @Override
    public List<Cotizacion> getAll() {
        return cotizacionDAO.getCotizacion();
    }

    public CotizacionDAO getCotizacionDAO() {
        return cotizacionDAO;
    }

    public void setCategoriaDAO(CotizacionDAO cotizacionDAO) {
        this.cotizacionDAO = cotizacionDAO;
    }
}


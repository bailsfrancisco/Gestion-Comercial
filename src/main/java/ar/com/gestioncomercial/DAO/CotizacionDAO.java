/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Cotizacion;
import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @author Bails Francisco
 */
@Stateless
public class CotizacionDAO extends AbstractDAO<Cotizacion> {

    public CotizacionDAO() {
        super(Cotizacion.class);
    }

    @Override
    protected List<Cotizacion> getAll() {
        return null;
    }

}
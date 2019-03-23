/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.SolicitudReparacion;
import javax.ejb.Stateless;
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
        return null;
    }

}

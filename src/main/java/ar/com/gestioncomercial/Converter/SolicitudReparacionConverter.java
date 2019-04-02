/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.Converter;

import ar.com.gestioncomercial.model.SolicitudReparacion;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bails Francisco
 */
@FacesConverter(forClass = SolicitudReparacion.class)
public class SolicitudReparacionConverter extends AbstractConverter<SolicitudReparacion> {

    @Override
    public String getDAOName() {
        return "SolicitudReparacionDAO";
    }
}

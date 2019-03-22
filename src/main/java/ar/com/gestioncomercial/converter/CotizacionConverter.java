/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.converter;

import ar.com.gestioncomercial.model.Cotizacion;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author bailsfrancisco
 */
@FacesConverter(forClass = Cotizacion.class)
public class CotizacionConverter extends AbstractConverter<Cotizacion> {

    @Override
    public String getDAOName() {
        return "CotizacionDAO";
    }
}

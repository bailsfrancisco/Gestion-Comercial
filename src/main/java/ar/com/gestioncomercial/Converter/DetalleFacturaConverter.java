/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.Converter;

import ar.com.gestioncomercial.model.DetalleFactura;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author bailsfrancisco
 */
@FacesConverter(forClass = DetalleFactura.class)
public class DetalleFacturaConverter extends AbstractConverter<DetalleFactura> {

    @Override
    public String getDAOName() {
        return "DetalleFacturaDAO";
    }
}

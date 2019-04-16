/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.Converter;

import ar.com.gestioncomercial.model.Factura;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author bailsfrancisco
 */
@FacesConverter(forClass = Factura.class)
public class FacturaConverter extends AbstractConverter<Factura> {

    @Override
    public String getDAOName() {
        return "FacturaDAO";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.Converter;

import ar.com.gestioncomercial.model.Proveedor;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bails Francisco
 */
@FacesConverter(forClass = Proveedor.class)
public class ProveedorConverter extends AbstractConverter<Proveedor> {

    @Override
    public String getDAOName() {
        return "ProveedorDAO";
    }
}

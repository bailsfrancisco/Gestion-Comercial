/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.Converter;

import ar.com.gestioncomercial.model.Producto;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bails Francisco
 */
@FacesConverter(forClass = Producto.class)
public class ProductoConverter extends AbstractConverter<Producto> {

    @Override
    public String getDAOName() {
        return "ProductoDAO";
    }

}

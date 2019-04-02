/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.Converter;

import ar.com.gestioncomercial.model.AbstractPersona;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bails Francisco
 */
@FacesConverter(forClass = AbstractPersona.class)
public class AbstractPersonaConverter extends AbstractConverter<AbstractPersona> {

    @Override
    public String getDAOName() {
        return "AbstractPersonaDAO";
    }
}

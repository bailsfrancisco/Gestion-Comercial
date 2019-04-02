/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.Converter;

import ar.com.gestioncomercial.DAO.AbstractDAO;
import ar.com.gestioncomercial.model.AbstractEntity;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author bailsfrancisco
 * @param <T>
 */
public abstract class AbstractConverter<T> implements Converter {

    public abstract String getDAOName();

    private AbstractDAO<T> getEntityDAO() {
        InitialContext ic;
        try {
            ic = new InitialContext();
            return (AbstractDAO<T>) ic.lookup("java:module/" + getDAOName());
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return this.getEntityDAO().find(Long.valueOf(value));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Long id = ((AbstractEntity) value).getId();
        return id == null ? "0" : id.toString();
    }
}

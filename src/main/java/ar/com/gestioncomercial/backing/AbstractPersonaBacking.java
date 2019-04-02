/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.backing;

import ar.com.gestioncomercial.DAO.UsuarioDAO;
import ar.com.gestioncomercial.controller.PersonaController;
import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.utils.JSFUtils;
import ar.com.gestioncomercial.utils.URLMap;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Bails Francisco
 */
public abstract class AbstractPersonaBacking implements Serializable, CRUDBacking<AbstractPersona> {

    @PostConstruct
    public void init() {

    }

    @EJB
    private URLMap urlMap;

    @EJB
    private PersonaController personaController;

    @EJB
    private UsuarioDAO usuarioDAO;

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public void delete(AbstractPersona entity) {
        try {
            personaController.borrarPersona(entity);
        } catch (Exception e) {
            JSFUtils.createFacesMessage(
                    String.format("Ocurrio un Error al intertar borrar '%s', Verifique que no es un empleado, proveedor o cliente.", entity.getNombre())
            );
        }
    }

    @Override
    public List<AbstractPersona> getAll() {
        return personaController.obtenerPersonas();
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }

    public PersonaController getPersonaController() {
        return personaController;
    }

    public void setPersonaController(PersonaController personaController) {
        this.personaController = personaController;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.AbstractPersonaDAO;
import ar.com.gestioncomercial.controller.PersonaController;
import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Usuario;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;

/**
 *
 * @author Bails Francisco
 */
public abstract class AbstractPersonaControllerImpl implements PersonaController {

    private static final Logger logger = Logger.getLogger(AbstractPersonaControllerImpl.class.getName());

    @EJB
    private AbstractPersonaDAO abstractPersonaDAO;

    @Override
    public void create(AbstractPersona persona) {
        try {
            abstractPersonaDAO.create(persona);

        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public AbstractPersona retrieve(AbstractPersona persona) {
        try {
            return abstractPersonaDAO.find(persona.getId());

        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    @Override
    public AbstractPersona retrievebyId(Long id) {
        return abstractPersonaDAO.find(id);
    }

    @Override
    public void update(AbstractPersona persona) {
        try {
            abstractPersonaDAO.update(persona);

        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void delete(AbstractPersona persona) {
        try {
            abstractPersonaDAO.delete(persona);

        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public AbstractPersona getByUsuario(Usuario usuario) {
        return abstractPersonaDAO.getByUsuario(usuario);
    }

    @Override
    public List<AbstractPersona> getAllAdmins() {
        return abstractPersonaDAO.getAdmins();
    }

    @Override
    public AbstractPersona obtenerClientePorCodigo() throws Exception {
        return abstractPersonaDAO.getClienteById();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.AbstractPersonaDAO;
import ar.com.gestioncomercial.DAO.ClienteDAO;
import ar.com.gestioncomercial.DAO.EmpleadoDAO;
import ar.com.gestioncomercial.DAO.ProveedorDAO;
import ar.com.gestioncomercial.controller.PersonaController;
import ar.com.gestioncomercial.model.AbstractPersona;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;

/**
 *
 * @author Bails Francisco
 */
@Stateless
public class PersonaControllerImpl implements PersonaController {

    private static final Logger logger = Logger.getLogger(PersonaControllerImpl.class.getName());

    @EJB
    private AbstractPersonaDAO abstractPersonaDAO;

    @EJB
    private ClienteDAO clienteDAO;

    @EJB
    private ProveedorDAO proveedorDAO;

    @EJB
    private EmpleadoDAO empleadoDAO;

    @Override
    public void insertarPersona(AbstractPersona persona) {
        try {
            abstractPersonaDAO.create(persona);

        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public AbstractPersona obtenerPersona(AbstractPersona persona) {
        try {
            return abstractPersonaDAO.find(persona.getId());

        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    @Override
    public AbstractPersona obtenerPersonaById(Long id) {
        return abstractPersonaDAO.find(id);
    }

    @Override
    public void actualizarPersona(AbstractPersona persona) {
        try {
            abstractPersonaDAO.update(persona);

        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void borrarPersona(AbstractPersona persona) {
        try {
            abstractPersonaDAO.delete(persona);

        } catch (EJBException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public List<AbstractPersona> obtenerPersonas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

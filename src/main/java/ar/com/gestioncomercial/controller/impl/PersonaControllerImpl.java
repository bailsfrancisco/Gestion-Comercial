package ar.com.gestioncomercial.controller.impl;

import ar.com.gestioncomercial.DAO.AbstractPersonaDAO;
import ar.com.gestioncomercial.controller.PersonaController;
import ar.com.gestioncomercial.model.AbstractPersona;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PersonaControllerImpl extends  AbstractPersonaControllerImpl implements PersonaController {

    @EJB
    private AbstractPersonaDAO abstractPersonaDAO;

    @Override
    public List<AbstractPersona> getAll() {
        return abstractPersonaDAO.getAllPersonas();
    }
}
